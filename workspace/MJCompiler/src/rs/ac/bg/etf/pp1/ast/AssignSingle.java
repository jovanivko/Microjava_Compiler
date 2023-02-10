// generated with ast extension for cup
// version 0.8
// 7/1/2023 22:6:28


package rs.ac.bg.etf.pp1.ast;

public class AssignSingle extends AssignList {

    private AssignDes AssignDes;

    public AssignSingle (AssignDes AssignDes) {
        this.AssignDes=AssignDes;
        if(AssignDes!=null) AssignDes.setParent(this);
    }

    public AssignDes getAssignDes() {
        return AssignDes;
    }

    public void setAssignDes(AssignDes AssignDes) {
        this.AssignDes=AssignDes;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AssignDes!=null) AssignDes.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AssignDes!=null) AssignDes.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AssignDes!=null) AssignDes.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AssignSingle(\n");

        if(AssignDes!=null)
            buffer.append(AssignDes.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AssignSingle]");
        return buffer.toString();
    }
}
