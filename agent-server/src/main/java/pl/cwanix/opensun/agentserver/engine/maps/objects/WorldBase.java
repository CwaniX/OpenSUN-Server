package pl.cwanix.opensun.agentserver.engine.maps.objects;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.datatypes.SUNAABB;
import pl.cwanix.opensun.utils.datatypes.SUNColor;
import pl.cwanix.opensun.utils.datatypes.Vector;
import pl.cwanix.opensun.utils.files.SUNArchive;
import pl.cwanix.opensun.utils.files.SUNArchiveChunkInfo;

@SuppressWarnings("checkstyle:MagicNumber")
@Slf4j
public class WorldBase {

    private static final Marker MARKER = MarkerFactory.getMarker("WORLD BASE");

    private static final String IDSTR_SUN_MAP = "WMAP";
    private static final int VERSION_SUN_MAP = 179;

    //create path finder?

    private Vector sunLightDir;
    private SUNColor mapAmbient;
    private SUNColor ambientDrawBase;
    private SUNColor shadowColor;
    private SUNColor sunLightColor;
    private int state;
    private int checkSum;

    public boolean serialize(final SUNArchive archive) {
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

        if (version >= 148) {
            SUNArchiveChunkInfo chunkInfo = archive.readChunk();

            if (chunkInfo.getId() != 0x1770) {
                throw new RuntimeException("" + chunkInfo.getId());
            }
        }

        if (version >= 136) {
            checkSum = BytesUtils.byteArrayToInt(archive.read(4));
        }

        sunLightDir = new Vector(archive.read(12));

        if (version >= 143) {
            sunLightColor = new SUNColor(archive.read(3));
        }

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

        if (version >= 152) {
            ambientDrawBase = new SUNColor(archive.read(3));
            shadowColor = new SUNColor(archive.read(3));
        }

        SUNColor fogColor;
        float fogStart;
        float fogEnd;
        float fogRate;
        if (version >= 132) {
            fogColor = new SUNColor(archive.read(3));
            fogStart = BytesUtils.byteArrayToFloat(archive.read(4));
            fogEnd = BytesUtils.byteArrayToFloat(archive.read(4));
            fogRate = BytesUtils.byteArrayToFloat(archive.read(4));
        } else {
            fogColor = new SUNColor((byte) 32, (byte) 32, (byte) 32);
            fogStart = 20.0f;
            fogEnd = 150.0f;
            fogRate = 100.0f;
        }

        if (version >= 135) {
            /*int iBlurCount;
            float fMinLuminance,fSelectHighLight,fFinalColorBlend;
            WzColor wcSelectColor;

            *pArchive >> iBlurCount >> fMinLuminance >>fSelectHighLight
                    >>wcSelectColor >>fFinalColorBlend;*/

            archive.read(19);
        }

        if (version >= 146) {
            /*float afSkipBuffer[8];
            pArchive->Read(&afSkipBuffer,sizeof(afSkipBuffer));*/

            archive.read(32);
        }

        return true;
    }
}
