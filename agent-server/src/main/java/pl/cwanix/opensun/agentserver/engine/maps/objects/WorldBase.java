package pl.cwanix.opensun.agentserver.engine.maps.objects;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.datatypes.SUNAABB;
import pl.cwanix.opensun.utils.datatypes.SUNColor;
import pl.cwanix.opensun.utils.datatypes.Vector;
import pl.cwanix.opensun.utils.files.SUNArchive;

@Slf4j
public class WorldBase {

    private static final Marker MARKER = MarkerFactory.getMarker("WORLD BASE");

    private static final String IDSTR_SUN_MAP = "WMAP";
    private static final int VERSION_SUN_MAP = 179;

	//create path finder?

    private Vector sunLightDir;
    private SUNColor mapAmbient;
    private int state;

    public boolean serialize(SUNArchive archive) {
        String identity = new String(archive.read(4));
        if (!IDSTR_SUN_MAP.equals(identity)) {
            log.error(MARKER, "Wrong map identity");

            return false;
        }

        int version = BytesUtils.byteArrayToShort(archive.read(2));
        if (version > VERSION_SUN_MAP) {
            log.error(MARKER, "Wrong map version: {}", version);

            return false;
        }

        sunLightDir = new Vector(archive.read(12));

        if (version >= 91) {
            mapAmbient = new SUNColor(archive.read(3));
        } else {
            mapAmbient = new SUNColor((byte) 255, (byte) 255, (byte) 255);
        }

        if (version >= 131) {
            int temp = BytesUtils.byteArrayToShort(archive.read(2));
            state &= 0xFFFF0000;
            state |= temp;
        }

        SUNAABB aabbTemp = new SUNAABB(archive.read(24));
        /*if ( !x_pOctree->Create( aabbTemp))
        {
            return ( FALSE);
        }

        DWORD dwFogColor=WzColor_RGB(32,32,32);
        float fFogStart=20.0f,fFogEnd=150.0f,fFogRate=100.0f;*/

        SUNColor fogColor;
        float fogStart;
        float fogEnd;
        float fogRate;
        if (version >= 132) {
            fogColor = new SUNColor(archive.read(4));
            fogStart = BytesUtils.byteArrayToFloat(archive.read(4));
            fogEnd = BytesUtils.byteArrayToFloat(archive.read(4));
            fogRate = BytesUtils.byteArrayToFloat(archive.read(4));
        } else {
            fogColor = new SUNColor((byte) 32, (byte) 32, (byte) 32);
            fogStart = 20.0f;
            fogEnd = 150.0f;
            fogRate = 100.0f;
        }

        return true;
    }
}
