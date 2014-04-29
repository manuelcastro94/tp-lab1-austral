package org.studyroom.control.dao;

import org.hibernate.Session;
import org.studyroom.model.tag.Tag;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 29/04/2014
 * Time: 17:20
 * To change this template use File | Settings | File Templates.
 */
public class TagDao extends DataAO {

    private static TagDao ourInstance = new TagDao();

    private TagDao() {
    }

    public static TagDao getInstance() {
        return ourInstance;
    }

    public void addTag(Session session, Tag Tag) {
        super.beginTransaction(session);
        session.save(Tag);
        super.endTransaction(session);
    }
}
