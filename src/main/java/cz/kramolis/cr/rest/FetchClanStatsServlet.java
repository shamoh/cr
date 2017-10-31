package cz.kramolis.cr.rest;

import com.google.gson.Gson;
import com.googlecode.objectify.Key;
import cz.kramolis.cr.domain.ClanEntity;
import cz.kramolis.cr.domain.MemberEntity;
import cz.kramolis.cr.remote.ClanModel;
import cz.kramolis.cr.remote.MemberModel;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.util.Date;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class FetchClanStatsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        InputStream inputStream = null;
        try {
            URL url = new URL("http://api.cr-api.com/clan/8Q2C0GVC");
            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(60000);  //60 Seconds
            conn.setReadTimeout(60000);  //60 Seconds
            inputStream = conn.getInputStream();
            Reader reader = new InputStreamReader(inputStream, "UTF-8");

            Gson gson = new Gson();
            ClanModel model = gson.fromJson(reader, ClanModel.class);
            System.out.println(">>> " + model);

            Instant timestamp = Instant.now();

            ClanEntity clan = from(timestamp, model);
            ofy().save().entity(clan);

            model.members
                    .forEach(member -> ofy().save().entity(from(timestamp, clan, member)));

            response.setDateHeader("Last-Modified", System.currentTimeMillis());
            response.setStatus(200);
            response.getWriter().append("OK: " + timestamp);
        } catch (Exception ex) {
            if (inputStream != null) {
                inputStream.close();
            }
            response.setDateHeader("Last-Modified", System.currentTimeMillis());
            response.setStatus(500);
            response.setContentType("text/html");
            response.getWriter().append("<pre>");
            ex.printStackTrace(response.getWriter());
            response.getWriter().append("</pre>");
        }
    }

    private static ClanEntity from(Instant timestamp, ClanModel model) {
        ClanEntity clan = new ClanEntity();

        clan.setTimestamp(Date.from(timestamp));
        clan.setId(ofy().factory().allocateId(ClanEntity.class).getId());
        clan.setTag(model.tag);
        clan.setName(model.name);
        clan.setMemberCount(model.memberCount);
        clan.setScore(model.score);
        clan.setRequiredScore(model.requiredScore);
        clan.setDonations(model.donations);
        clan.setTypeName(model.typeName);
        clan.setClanChestCrowns(model.clanChest.clanChestCrowns);

        return clan;
    }

    private static MemberEntity from(Instant timestamp, ClanEntity clan, MemberModel model) {
        MemberEntity member = new MemberEntity();

        member.setClan(Key.create(clan));
        member.setTimestamp(Date.from(timestamp));
        member.setId(ofy().factory().allocateId(MemberEntity.class).getId());
        member.setTag(model.tag);
        member.setName(model.name);
        member.setExpLevel(model.expLevel);
        member.setTrophies(model.trophies);
        member.setDonations(model.donations);
        member.setClanChestCrowns(model.clanChestCrowns);
        member.setScore(model.score);
        member.setRoleName(model.roleName);
        member.setArenaID(model.arena.arenaID);

        return member;
    }

}
