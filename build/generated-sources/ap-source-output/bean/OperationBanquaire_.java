package bean;

import bean.Compte;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-30T22:19:34")
@StaticMetamodel(OperationBanquaire.class)
public class OperationBanquaire_ { 

    public static volatile SingularAttribute<OperationBanquaire, Double> montant;
    public static volatile SingularAttribute<OperationBanquaire, Long> id;
    public static volatile SingularAttribute<OperationBanquaire, Integer> type;
    public static volatile SingularAttribute<OperationBanquaire, Date> dateOperationBanquaire;
    public static volatile SingularAttribute<OperationBanquaire, Compte> compte;

}