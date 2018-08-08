package Offer;

import java.util.ArrayList;

//序列化二叉树
public class Test37 {
    //方法一
    //1. 利用前序遍历序列化二叉树，然后从记录的字符串中反序列化二叉树。
    //2. 遇到空节点需要用特殊字符加以标记。如“#”
    public int index = -1;
    String Serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        if(root == null){
            s.append("#,");
            return s.toString();
        }
        s.append(root.val+",");
        s.append(Serialize(root.left));
        s.append(Serialize(root.right));
        return s.toString();
    }
    TreeNode Deserialize(String str) {
        index++;
        String[] DLRseq = str.split(",");
        TreeNode leave = null;
        if(!DLRseq[index].equals("#")){
            leave = new TreeNode(Integer.valueOf(DLRseq[index]));
            leave.left = Deserialize(str);
            leave.right = Deserialize(str);
        }
        return leave;
    }


    //方法二
    //1. 层序遍历二叉树，序列化二叉树
    //2. 空节点需要使用特殊字符记录。将二叉树序列化成为一颗完全二叉树，然后反序列化二叉树。
    String Serialize1(TreeNode root) {
        if(root == null){
            return null;
        }
        StringBuffer sb = new StringBuffer();
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        int count = (1 << treeDepth(root)) - 1;//计数，拿到此树的深度后计算对应完全二叉树节点数
        list.add(root);
        count--;
        TreeNode tmpNode = null;

        //层次遍历二叉树，开始序列化
        while(list.size() > 0 && count >= 0){
            tmpNode = list.remove(0);
            if(tmpNode != null){
                sb.append(tmpNode.val+",");
                list.add(tmpNode.left);
                list.add(tmpNode.right);
            }else{
                sb.append("#,");//#作为空节点占位符
                list.add(null);
                list.add(null);
            }
            count --;
        }
        return sb.toString();
    }

    TreeNode Deserialize1(String str) {
        if(str == null || str.length() == 0){
            return null;
        }
        return Deserialize(str.split(","), 0);
    }

    TreeNode Deserialize(String[] strings, int index){
        TreeNode newNode = null;
        if(index < strings.length){
            if(!strings[index].equals("#")){
                newNode = new TreeNode(Integer.parseInt(strings[index]));
                newNode.left = Deserialize(strings, 2 * index + 1);
                newNode.right = Deserialize(strings, 2 * index + 2);
            }
        }
        return newNode;
    }
    int treeDepth(TreeNode root){
        int depth = 0;
        if(root == null){
            return depth;
        }else{
            int lDepth = treeDepth(root.left) + 1;
            int rDepth = treeDepth(root.right) + 1;
            return lDepth > rDepth ? lDepth : rDepth;
        }
    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
}
