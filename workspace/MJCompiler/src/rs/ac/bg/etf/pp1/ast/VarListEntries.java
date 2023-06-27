// generated with ast extension for cup
// version 0.8
// 27/5/2023 16:18:2


package rs.ac.bg.etf.pp1.ast;

public class VarListEntries extends VarListEntry {

    private VarListEntry VarListEntry;
    private VarName VarName;

    public VarListEntries (VarListEntry VarListEntry, VarName VarName) {
        this.VarListEntry=VarListEntry;
        if(VarListEntry!=null) VarListEntry.setParent(this);
        this.VarName=VarName;
        if(VarName!=null) VarName.setParent(this);
    }

    public VarListEntry getVarListEntry() {
        return VarListEntry;
    }

    public void setVarListEntry(VarListEntry VarListEntry) {
        this.VarListEntry=VarListEntry;
    }

    public VarName getVarName() {
        return VarName;
    }

    public void setVarName(VarName VarName) {
        this.VarName=VarName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarListEntry!=null) VarListEntry.accept(visitor);
        if(VarName!=null) VarName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarListEntry!=null) VarListEntry.traverseTopDown(visitor);
        if(VarName!=null) VarName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarListEntry!=null) VarListEntry.traverseBottomUp(visitor);
        if(VarName!=null) VarName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarListEntries(\n");

        if(VarListEntry!=null)
            buffer.append(VarListEntry.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarName!=null)
            buffer.append(VarName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarListEntries]");
        return buffer.toString();
    }
}
