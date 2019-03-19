package com.middol.test.Model;

import java.util.List;

public class TableData {

    //表格一行数据
    private List<TableRowData> tableRowDataList;

    @Override
    public String toString() {
        return "TableData{" +
                "tableRowDataList=" + tableRowDataList +
                '}';
    }

    public TableData() {

    }

    public TableData(List<TableRowData> tableRowDataList) {
        this.tableRowDataList = tableRowDataList;
    }

    public List<TableRowData> getTableRowDataList() {
        return tableRowDataList;
    }

    public void setTableRowDataList(List<TableRowData> tableRowDataList) {
        this.tableRowDataList = tableRowDataList;
    }
}
