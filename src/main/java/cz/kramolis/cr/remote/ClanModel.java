package cz.kramolis.cr.remote;

import java.util.List;

public class ClanModel {

    public String tag;
    public String name;
    public int memberCount;
    public int score;
    public int requiredScore;
    public int donations;
    public String typeName;
    public ClanChestModel clanChest;
    public List<MemberModel> members;

    @Override
    public String toString() {
        return "ClanModel{" +
                "tag='" + tag + '\'' +
                ", name='" + name + '\'' +
                ", memberCount=" + memberCount +
                ", score=" + score +
                ", requiredScore=" + requiredScore +
                ", donations=" + donations +
                ", typeName='" + typeName + '\'' +
                ", clanChest=" + clanChest +
                ", members=" + members +
                '}';
    }
}
