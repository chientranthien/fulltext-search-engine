package com.chientt.search.storage.util;

import static com.chientt.search.constant.GlobalConstant.DATA_SEPARATED_CHAR;
import com.chientt.search.storage.entity.IndexData;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static com.chientt.search.constant.GlobalConstant.ENCODED_INDEX_POS;
import static com.chientt.search.constant.GlobalConstant.ENCODED_OFFSETS_POS;
import static com.chientt.search.constant.GlobalConstant.INDEX_SEPARATED_CHAR;
import com.chientt.search.storage.entity.Data;

public class DataUtils {

    public static String encode(String str) {
        byte[] encoded = Base64.
                getEncoder()
                .encode(str.getBytes());
        return new String(encoded);
    }

    public static String decode(String str) {
        byte[] decoded = Base64
                .getDecoder()
                .decode(str);
        return new String(decoded);
    }

    public static String encodeIndexData(IndexData indexData) {
        String encodedIndex = encode(indexData.getIndex());
        String offsetsAsStr = "";
        for (Long offset : indexData.getOffset()) {
            offsetsAsStr += INDEX_SEPARATED_CHAR + offset;
        }

        String encodedOffsets = encode(offsetsAsStr);

        return encodedIndex + INDEX_SEPARATED_CHAR + encodedOffsets;

    }

    public static IndexData decodeIndexData(String encodedIndexData) {
        String[] splitted = encodedIndexData.split(INDEX_SEPARATED_CHAR);
        String index = decode(splitted[ENCODED_INDEX_POS]);
        String encodedOffsets = decode(splitted[ENCODED_OFFSETS_POS]);
        List<Long> offsets = decodeOffsets(encodedOffsets);
        return new IndexData(index, offsets);
    }

    private static List<Long> decodeOffsets(String encodedOffsets) {
        String offsetsAsStr = decode(encodedOffsets);
        String[] splittedOffsetsStr = offsetsAsStr.split(INDEX_SEPARATED_CHAR);
        List<Long> offsets = new ArrayList<>();
        for (String offset : splittedOffsetsStr) {
            offsets.add(Long.valueOf(offset));
        }

        return offsets;
    }

    public static String encodeData(Data data) {
        String encodedId = encode(data.get_id());
        String encodedvalue = encode(data.getValue());
        return encodedId + DATA_SEPARATED_CHAR + encodedvalue;
    }

    public static Data decodeData(String line) {
        String[] splitted = line.split(DATA_SEPARATED_CHAR);
        String decodedId = decode(splitted[0]);
        String decodedValue = decode(splitted[1]);
        return new Data(decodedId, decodedValue);
    }
}
