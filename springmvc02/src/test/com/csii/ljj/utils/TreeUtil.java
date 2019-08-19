package com.csii.ljj.utils;

import java.util.List;

public class TreeUtil {
    /**
     * 根据节点数据集合，生成XML
     * @param treeNodes 权节点集合
     * @return
     */
    public String parseNodeToXML(List<TreeNode> treeNodes) {
        StringBuffer xmlnodes = new StringBuffer();
        if (treeNodes != null && treeNodes.size() > 0) {
            xmlnodes.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            xmlnodes.append("<nodes>");
            for (int i = 0; i < treeNodes.size(); i++) {
                TreeNode node = treeNodes.get(i);
                xmlnodes.append("<node nodeId='" + node.getNodeId() + "' parentId='" + node.getParentId()
                        + "' hrefAddress='" + node.getHrefAddress() + "'>" + node.getNodeName() + "</node>");
            }
            xmlnodes.append("</nodes>");
        }

        return xmlnodes.toString();
    }
}