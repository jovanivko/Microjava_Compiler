// generated with ast extension for cup
// version 0.8
// 7/1/2023 22:6:28


package rs.ac.bg.etf.pp1.ast;

public class ErrExtendClass extends ClassExtend {

    public ErrExtendClass () {
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
        buffer.append("ErrExtendClass(\n");

        buffer.append(tab);
        buffer.append(") [ErrExtendClass]");
        return buffer.toString();
    }
}
