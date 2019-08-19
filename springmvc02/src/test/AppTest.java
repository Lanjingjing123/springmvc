import com.csii.ljj.utils.TreeNode;
import com.csii.ljj.utils.TreeUtil;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class AppTest {

    public static void main(String[] args) throws Exception {
        List<TreeNode> list = new ArrayList<TreeNode>();

        for (int i = 0; i < 5; i++) {
            TreeNode treeNode = new TreeNode();
            treeNode.setHrefAddress("hrefAddress" + i);
            treeNode.setId(i);
            treeNode.setNodeId("nodeId" + i);
            treeNode.setNodeName("nodeName" + i);
            treeNode.setParentId("parentId" + i);
            list.add(treeNode);
        }

        String xmlFile = new TreeUtil().parseNodeToXML(list);

        FileWriter writer = new FileWriter("F:/node.xml");

        writer.write(xmlFile);
        writer.flush();
        writer.close();
        System.out.println("写入完成！");
    }
}
