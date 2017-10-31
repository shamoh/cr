package cz.kramolis.cr.domain;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.Date;

@Entity(name = "members")
public class MemberEntity {
    @Index
    private Key<ClanEntity> clan;
    @Id
    private Long id;
    @Index
    private Date timestamp;
    @Index
    private String tag;
    @Index
    private String name;
    @Index
    private int expLevel;
    @Index
    private int trophies;
    @Index
    private int donations;
    @Index
    private int clanChestCrowns;
    @Index
    private int score;
    @Index
    private String roleName;
    @Index
    private int arenaID;

    public Key<ClanEntity> getClan() {
        return clan;
    }

    public void setClan(Key<ClanEntity> clan) {
        this.clan = clan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getExpLevel() {
        return expLevel;
    }

    public void setExpLevel(int expLevel) {
        this.expLevel = expLevel;
    }

    public int getTrophies() {
        return trophies;
    }

    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }

    public int getDonations() {
        return donations;
    }

    public void setDonations(int donations) {
        this.donations = donations;
    }

    public int getClanChestCrowns() {
        return clanChestCrowns;
    }

    public void setClanChestCrowns(int clanChestCrowns) {
        this.clanChestCrowns = clanChestCrowns;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getArenaID() {
        return arenaID;
    }

    public void setArenaID(int arenaID) {
        this.arenaID = arenaID;
    }

    @Override
    public String toString() {
        return "MemberEntity{" +
                "clan=" + clan +
                ", id=" + id +
                ", timestamp=" + timestamp +
                ", tag='" + tag + '\'' +
                ", name='" + name + '\'' +
                ", expLevel=" + expLevel +
                ", trophies=" + trophies +
                ", donations=" + donations +
                ", clanChestCrowns=" + clanChestCrowns +
                ", score=" + score +
                ", roleName='" + roleName + '\'' +
                ", arenaID=" + arenaID +
                '}';
    }
}
