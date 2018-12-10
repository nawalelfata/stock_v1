package bean;

import bean.OperationBanquaire;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-30T22:19:34")
@StaticMetamodel(Compte.class)
public class Compte_ { 

    public static volatile SingularAttribute<Compte, Double> solde;
    public static volatile ListAttribute<Compte, OperationBanquaire> operationBanquaires;
    public static volatile SingularAttribute<Compte, String> id;

}