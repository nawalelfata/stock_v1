package bean;

import bean.Magasin;
import bean.Produit;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-30T22:19:34")
@StaticMetamodel(Stock.class)
public class Stock_ { 

    public static volatile SingularAttribute<Stock, Produit> produit;
    public static volatile SingularAttribute<Stock, Long> id;
    public static volatile SingularAttribute<Stock, Magasin> magasin;
    public static volatile SingularAttribute<Stock, BigDecimal> quantite;

}