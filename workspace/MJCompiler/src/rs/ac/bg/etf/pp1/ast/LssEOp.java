// generated with ast extension for cup
// version 0.8
// 27/5/2023 16:18:2


package rs.ac.bg.etf.pp1.ast;

public class LssEOp extends RelOp {

    public LssEOp () {
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
        buffer.append("LssEOp(\n");

        buffer.append(tab);
        buffer.append(") [LssEOp]");
        return buffer.toString();
    }
}
