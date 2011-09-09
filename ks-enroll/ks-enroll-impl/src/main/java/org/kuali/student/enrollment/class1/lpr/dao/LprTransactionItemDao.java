package org.kuali.student.enrollment.class1.lpr.dao;

import java.util.List;

import org.kuali.student.enrollment.class1.lpr.model.LprTransactionEntity;
import org.kuali.student.enrollment.class1.lpr.model.LprTransactionItemEntity;
import org.kuali.student.enrollment.dao.GenericEntityDao;

public class LprTransactionItemDao extends GenericEntityDao<LprTransactionItemEntity> {
    public List<LprTransactionItemEntity> getLprTransactionItemByLpr(String lprId) {
        return em.createQuery("from LprTransactionItemEntity a  where a.lprId=:lprId").setParameter("lprId", lprId)
                .getResultList();
    }

    public List<LprTransactionEntity> getByLprTransactionItemId(String lprTransactionItemId) {
        return em.createQuery("from LprTransactionEntity a  where :lprTransactionItemId  IN a.lprTransactionItems")
                .setParameter("lprId", lprTransactionItemId).getResultList();
    }

    public List<LprTransactionItemEntity> getLprTransactionItemByPerson(String personId) {
        return em.createQuery("from LprTransactionItemEntity a where  a.personId = :personId")
                .setParameter("personId", personId).getResultList();
    }

    public List<LprTransactionItemEntity> getLprTransactionItemByLprTrans(String lprTransId) {
        return em.createQuery("select a.lprTransItems from LprTransactionEntity a where  a.id = :lprTransId")
                .setParameter("lprTransId", lprTransId).getResultList();
    }

}
