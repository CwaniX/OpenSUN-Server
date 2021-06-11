package pl.cwanix.opensun.agentserver.engine.npc;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import pl.cwanix.opensun.agentserver.engine.npc.structures.NpcInfoStructure;
import pl.cwanix.opensun.agentserver.engine.npc.structures.ShopInfoStructure;
import pl.cwanix.opensun.agentserver.engine.npc.structures.ShopItemStructure;
import pl.cwanix.opensun.agentserver.engine.npc.structures.ShopTabStructure;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.utils.files.SUNFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Getter
@Setter
@Service
@RequiredArgsConstructor
public class ShopInfoParser implements InitializingBean {

    private static final Marker MARKER = MarkerFactory.getMarker("SHOP INFO PARSER");

    private static final String SHOP_INFO_FILE_NAME = "shopinfo.txt";
    private static final int SHOP_TAB_SLOTS_COUNT = 25;

    private static final BinaryOperator<ShopInfoStructure> shopMerger = (existing, replacer) -> {
        existing.getTabs().putAll(replacer.getTabs());

        return existing;
    };

    private final AgentServerProperties properties;

    private Map<Integer, ShopInfoStructure> shopInfoStructureMap;

    private void loadShopInfo() throws IOException {
        final List<ShopInfoStructure> ungroupedShops = new ArrayList<>();

        try (SUNFileReader reader = new SUNFileReader(properties.getDataDirectory() + "/" + SHOP_INFO_FILE_NAME)) {
            while (reader.readLine()) {
                ShopInfoStructure info = new ShopInfoStructure();
                info.setId(reader.readNextIntValue());
                info.setName(reader.readNextStringValue());
                info.setLottoRatio(reader.readNextIntValue());
                info.setTabs(new HashMap<>());

                ShopTabStructure tab = new ShopTabStructure();
                tab.setId(reader.readNextIntValue());
                tab.setShopId(info.getId());
                tab.setItems(new HashMap<>());

                for (int i = 0; i < SHOP_TAB_SLOTS_COUNT; i++) {
                    ShopItemStructure item = new ShopItemStructure();
                    item.setId(reader.readNextIntValue());
                    item.setTabId(tab.getId());
                    item.setCount(reader.readNextIntValue());
                    item.setType(reader.readNextIntValue());

                    if (item.getId() != 0) {
                        tab.getItems().put(i, item);
                    }
                }

                info.getTabs().put(tab.getId(), tab);

                ungroupedShops.add(info);
            }


        }

        shopInfoStructureMap = ungroupedShops.stream()
                .collect(Collectors.toMap(ShopInfoStructure::getId, Function.identity(), shopMerger));

        log.info(MARKER, "Loaded shop data: {}", shopInfoStructureMap.size());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        loadShopInfo();
    }
}
