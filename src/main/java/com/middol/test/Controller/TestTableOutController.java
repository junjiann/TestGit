package com.middol.test.Controller;

import com.middol.test.Model.SlideData;
import com.middol.test.Model.TableData;
import com.middol.test.Model.TableRowData;
import com.middol.test.Util.PowerPointGenerator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.*;

@RestController
@RequestMapping("/test")
public class TestTableOutController {
    @RequestMapping(value = "/tableout", method= { RequestMethod.POST })
    public void TableOut(@RequestBody Map<String,Object> passMap){
        String templateFile = System.getProperty("user.dir") +
                File.separator + "src\\main\\resources\\temp.pptx";

        String resultFile = System.getProperty("user.dir") +
                File.separator + "src\\main\\resources\\result01.pptx";

        Map<Integer, SlideData> data = new HashMap<>();
        SlideData slideData = new SlideData();
        Map<String, String> textDataTest = (Map<String, String>) passMap.get("textData");
        slideData.setTextMap(textDataTest);
        List<List> tableTest = (List<List>) passMap.get("tableData");
        List<TableData> list = new ArrayList<>();
        TableData tableData = new TableData();
        List<TableRowData> tableRowDataList = new ArrayList<>();
        for (int i =0; i < tableTest.size(); i++){
                TableRowData tableRowData = new TableRowData();
                List<String> strings = new ArrayList<>();
                tableRowData.setDataList(tableTest.get(i));
                tableRowDataList.add(tableRowData);
        }
        tableData.setTableRowDataList(tableRowDataList);
        list.add(tableData);
        slideData.setTableDataList(list);
        data.put(7, slideData);
        data.put(6, slideData);

        PowerPointGenerator.generatorPowerPoint(templateFile, resultFile, data);
    }

}
