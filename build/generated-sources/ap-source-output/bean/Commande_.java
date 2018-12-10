package bean;

import bean.Client;
import bean.CommandeItem;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-30T22:19:34")
@StaticMetamodel(Commande.class)
public class Commande_ { 

    public static volatile SingularAttribute<Commande, String> reference;
    public static volatile SingularAttribute<Commande, BigDecimal> totalRestant;
    public static volatile SingularAttribute<Commande, BigDecimal> total;
    public static volatile SingularAttribute<Commande, BigDecimal> totalPaye;
    public static volatile SingularAttribute<Commande, Client> client;
    public static volatile SingularAttribute<Commande, Long> id;
    public static volatile SingularAttribute<Commande, Date> dateCommande;
    public static volatile SingularAttribute<Commande, BigDecimal> remise;
    public static volatile SingularAttribute<Commande, Integer> etat;
    public static volatile ListAttribute<Commande, CommandeItem> items;

}