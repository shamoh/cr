package cz.kramolis.cr.domain;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.Date;

@Entity(name = "clans")
public class ClanEntity {
    @Id
    private Long id;
    @Index
    private Date timestamp;
    @Index
    private String tag;
    @Index
    private String name;
    @Index
    private int memberCount;
    @Index
    private int score;
    @Index
    private int requiredScore;
    @Index
    private int donations;
    @Index
    private String typeName;
    @Index
    private int clanChestCrowns;

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

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRequiredScore() {
        return requiredScore;
    }

    public void setRequiredScore(int requiredScore) {
        this.requiredScore = requiredScore;
    }

    public int getDonations() {
        return donations;
    }

    public void setDonations(int donations) {
        this.donations = donations;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getClanChestCrowns() {
        return clanChestCrowns;
    }

    public void setClanChestCrowns(int clanChestCrowns) {
        this.clanChestCrowns = clanChestCrowns;
    }

    @Override
    public String toString() {
        return "ClanEntity{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", name='" + name + '\'' +
                ", timestamp=" + timestamp +
                ", memberCount=" + memberCount +
                ", score=" + score +
                ", requiredScore=" + requiredScore +
                ", donations=" + donations +
                ", typeName='" + typeName + '\'' +
                ", clanChestCrowns=" + clanChestCrowns +
                '}';
    }
}
