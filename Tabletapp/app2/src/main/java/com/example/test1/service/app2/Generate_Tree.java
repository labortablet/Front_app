package com.example.test1.service.app2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grit on 24.07.2014.
 */
public class Generate_Tree {
   private Project project ;
   private Tree tree = new Tree();
   private Node node = new Node();
    private List entry_List = new ArrayList();

    public Generate_Tree(Project project,Experiment experiment,List<Entry> entries){
        project = project;
        node.setData(experiment);
        entry_List = entries;
        tree();
    }
    private void tree(){
        Tree generated_Tree = new Tree();
        generated_Tree.setRootElement(node);
        generated_Tree.getRootElementNode().setChildren(entry_List);
        tree = generated_Tree;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }


}
