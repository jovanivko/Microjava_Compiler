// generated with ast extension for cup
// version 0.8
// 27/5/2023 21:32:19


package rs.ac.bg.etf.pp1.ast;

public class NeqOp extends RelOp {

    public NeqOp () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NeqOp(\n");

        buffer.append(tab);
        buffer.append(") [NeqOp]");
        return buffer.toString();
    }
}
