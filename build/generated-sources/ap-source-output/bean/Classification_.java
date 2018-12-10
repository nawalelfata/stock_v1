package bean;

import bean.Produit;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-30T22:19:34")
@StaticMetamodel(Classification.class)
public class Classification_ { 

    public static volatile ListAttribute<Classification, Produit> produits;
    public static volatile SingularAttribute<Classification, String> libelle;
    public static volatile SingularAttribute<Classification, Long> id;

}