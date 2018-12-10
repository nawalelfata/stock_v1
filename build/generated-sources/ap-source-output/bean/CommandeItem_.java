package bean;

import bean.Commande;
import bean.Produit;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-30T22:19:34")
@StaticMetamodel(CommandeItem.class)
public class CommandeItem_ { 

    public static volatile SingularAttribute<CommandeItem, Produit> produit;
    public static volatile SingularAttribute<CommandeItem, BigDecimal> prix;
    public static volatile SingularAttribute<CommandeItem, Long> id;
    public static volatile SingularAttribute<CommandeItem, Commande> commande;
    public static volatile SingularAttribute<CommandeItem, BigDecimal> quantite;

}