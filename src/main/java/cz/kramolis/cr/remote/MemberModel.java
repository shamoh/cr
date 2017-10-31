package cz.kramolis.cr.remote;

public class MemberModel {

    public String tag;
    public String name;
    public String roleName;
    public int expLevel;
    public int trophies;
    public int donations;
    public int score;
    public int clanChestCrowns;
    public ArenaModel arena;

    @Override
    public String toString() {
        return "MemberModel{" +
                "tag='" + tag + '\'' +
                ", name='" + name + '\'' +
                ", roleName='" + roleName + '\'' +
                ", expLevel=" + expLevel +
                ", trophies=" + trophies +
                ", donations=" + donations +
                ", score=" + score +
                ", clanChestCrowns=" + clanChestCrowns +
                ", arena=" + arena +
                '}';
    }
}
