package com.green.greengramver3.common;

import org.junit.jupiter.api.Test;
import java.io.File;

class CustomFileUtilsTest {

    @Test
    void deleteFolder() {
        String delFolderPath = "D:/Yerim/delFolder";
        File delFolder = new File(delFolderPath);
        delFolder.delete();
        // 폴더 안에 파일이나 디렉토리가 하나라도 있으면 삭제 안 됨)
    }

    @Test
    void deleteFolder2() {
        String delFolderPath = "D:/Yerim/delFolder";
        File delFolder = new File(delFolderPath);
        delFolder.delete();
    }

    @Test
    void deleteFolder3() {
        CustomFileUtils customFileUtils = new CustomFileUtils("");
        String delFolderPath = "D:/Yerim/delFolder";
        customFileUtils.deleteFolder(delFolderPath);
    }
}