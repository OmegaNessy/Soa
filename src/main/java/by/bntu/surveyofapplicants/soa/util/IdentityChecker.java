package by.bntu.surveyofapplicants.soa.util;

import by.bntu.surveyofapplicants.soa.entity.IdentityCheckable;

public class IdentityChecker {
    public <T extends IdentityCheckable> boolean check(T dbObj,T pageObj){
        if (null == dbObj){
            return true;
        }
        return dbObj.getName().equals(pageObj.getName()) && pageObj.getId().equals(dbObj.getId());
    }
}
