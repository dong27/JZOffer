package Leetcode;

import java.util.ArrayList;
import java.util.List;

//不同的二叉搜索树 II
//给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
public class Test95 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<TreeNode> generateTrees(int n) {
        List<Integer> nums = new ArrayList<>();
        if(n==0)
        {
            return new ArrayList<>();
        }
        for (int i = 0; i < n; i++)
        {
            nums.add(i + 1);
        }
        return generateTreeNode(nums);
    }

    private List<TreeNode> generateTreeNode(List<Integer> nums) {
        if (nums.size() == 0)
        {
            return null;
        }
        List<TreeNode> resNodes = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++)
        {
            List<TreeNode> leftNodes = generateTreeNode(nums.subList(0, i));
            List<TreeNode> rightNodes = generateTreeNode(nums.subList(i + 1, nums.size()));
            if (leftNodes != null)
            {
                for (TreeNode leftNode : leftNodes)
                {
                    if (rightNodes != null)
                    {
                        for (TreeNode rightNode : rightNodes)
                        {
                            TreeNode pNode = new TreeNode(nums.get(i));
                            pNode.left = leftNode;
                            pNode.right = rightNode;
                            resNodes.add(pNode);
                        }
                    }
                    else
                    {
                        TreeNode pNode = new TreeNode(nums.get(i));
                        pNode.left = leftNode;
                        pNode.right = null;
                        resNodes.add(pNode);
                    }
                }
            }
            else
            {
                if (rightNodes != null)
                {
                    for (TreeNode rightNode : rightNodes)
                    {
                        TreeNode pNode = new TreeNode(nums.get(i));
                        pNode.left = null;
                        pNode.right = rightNode;
                        resNodes.add(pNode);
                    }
                }
                else
                {
                    TreeNode pNode = new TreeNode(nums.get(i));
                    pNode.left = null;
                    pNode.right = null;
                    resNodes.add(pNode);
                }
            }
        }
        return resNodes;
    }
}
