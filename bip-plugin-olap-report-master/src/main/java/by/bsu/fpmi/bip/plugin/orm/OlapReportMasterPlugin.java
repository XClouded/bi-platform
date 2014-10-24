package by.bsu.fpmi.bip.plugin.orm;

import by.bsu.fpmi.bip.plugin.api.Plugin;

final class OlapReportMasterPlugin implements Plugin {
    @Override
    public void invoke() {
        System.out.println("Hello from OLAP Report Master!");
    }
}
