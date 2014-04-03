package ecommerce.domain.jcr;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.eval.PathPredicateEvaluator;
import com.day.cq.search.impl.builder.QueryBuilderImpl;
import com.day.cq.search.result.ResultPage;
import com.day.cq.search.result.SearchResult;
import com.day.crx.sling.testing.RepositoryBaseTest;
import org.apache.jackrabbit.JcrConstants;
import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.jackrabbit.commons.cnd.CndImporter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.ComponentFactory;
import org.osgi.service.component.ComponentInstance;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.nodetype.NodeType;
import javax.jcr.nodetype.NodeTypeManager;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class CategoriesQueryTest extends RepositoryBaseTest {


    public static final String SLING_FOLDER = "sling:Folder";

    //    @Test
    public void testName() throws Exception {
        final SlingRepository repository = getRepository();

        Session login = repository.login(new SimpleCredentials("admin", "admin".toCharArray()));


        NodeTypeManager nodeTypeManager = login.getWorkspace().getNodeTypeManager();

        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("all_node_types.txt");

        NodeType[] nodeTypes = CndImporter.registerNodeTypes(new InputStreamReader(resourceAsStream), login);

        nodeTypeManager.registerNodeTypes(nodeTypes, true);


        JcrUtils.getOrCreateByPath("/etc", SLING_FOLDER, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce", SLING_FOLDER, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol", SLING_FOLDER, JcrConstants.NT_UNSTRUCTURED, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/bbq", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/bbq/bbq-bbq", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);
        setupNode(JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/bbq/bbq-bbq/12840",
                JcrConstants.NT_UNSTRUCTURED,
                JcrConstants.NT_UNSTRUCTURED, login, true),
                new String[]{"bbq-bbq"},
                "12840",
                "12840",
                new String[]{"winning:shop/bbq/bbq-bbq"},
                "Beefeater BBQ 12840",
                "Beefeater BBQ 12840",
                "12840",
                "",
                "/aol/products/12840",
                "bbq");


        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/bbq/bbq-bbqRangehood", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/cooking", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/cooking/cooking-accessories", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);

        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/cooking/cooking-cooker", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);

        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/cooking/cooking-cooktops", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);

        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/cooking/cooking-deepFryer", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);

        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/cooking/cooking-electricFryPanAndWok", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);

        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/cooking/cooking-ovens", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/cooking/cooking-ovens/cooking-ovens-builtInOven", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/cooking/cooking-ovens/cooking-ovens-builtInOven/cooking-ovens-builtInOven-combination", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/cooking/cooking-ovens/cooking-ovens-builtInOven/cooking-ovens-builtInOven-conventional", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/cooking/cooking-ovens/cooking-ovens-builtInOven/cooking-ovens-builtInOven-fanOven", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/cooking/cooking-ovens/cooking-ovens-builtInOven/cooking-ovens-builtInOven-multiFunction", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/cooking/cooking-ovens/cooking-ovens-builtInOven/cooking-ovens-builtInOven-steam", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);

        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/cooking/cooking-rangehoods", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);

        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/cooking/cooking-stoves", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);

        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/dishWasherAndSink", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/fridgeAndFreezer", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/heatingAndCooling", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/smallAppliances", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/tvAndAudio", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);
        JcrUtils.getOrCreateByPath("/etc/commerce/products/aol/aolProductCatalog/en/shop/washerAndDryer", JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, login, true);


        QueryBuilder queryBuilder = stubbedQueryBuilder();

        Map<String,String> predicateParameterMap = new HashMap<String,String>();

        predicateParameterMap.put("path", "/etc/commerce/products/aol/aolProductCatalog/en/shop");
        predicateParameterMap.put("type", SLING_FOLDER);
        predicateParameterMap.put("p.depth", "-1");

        Query query = queryBuilder.createQuery(PredicateGroup.create(predicateParameterMap), login);
        query.setHitsPerPage(100);
        SearchResult result = query.getResult();


        System.out.println(result.getHits().size());

        Iterator<Resource> resources = result.getResources();
        while (resources.hasNext()) {
            System.out.println(resources.next().getPath());
        }

        login.getRootNode().getNode("etc/commerce").remove();
        login.save();
        login.logout();


    }

    private QueryBuilderImpl stubbedQueryBuilder() {
        return new QueryBuilderImpl() {

            @Override
            public ResourceResolver createResourceResolver(Session session) {
                return getResolverFactory().getResourceResolver(session);
            }

            @Override
            public <ComponentT> ComponentT getComponent(Class<ComponentT> typeClass, String type, Dictionary properties) {
                return null;
            }
        };
    }

    private void setupNode(Node product, String[] categories, String code, String hybrisProductId, String[] cqTags, String jcrTitle, String description, String sku, String summary, String url, final String classificationName) throws RepositoryException {
        product.setProperty("categories", categories);
        product.setProperty("code", code);
        product.setProperty("cq:commerceType", "product");
        product.setProperty("cq:hybrisProductId", hybrisProductId);
        product.setProperty("cq:tags" , cqTags);
        product.setProperty("jcr:title" , jcrTitle);
        product.setProperty("description" , description);
        product.setProperty("purchasable" , true);
        product.setProperty("sku" , sku);
        product.setProperty("sling:resourceType", "commerce/components/product");
        product.setProperty("summary", summary);
        product.setProperty("url", url);

        Node classifications = JcrUtils.getOrCreateByPath(product, "classifications", false, JcrConstants.NT_UNSTRUCTURED, JcrConstants.NT_UNSTRUCTURED, true);
        Node dimensions = JcrUtils.getOrCreateByPath(classifications, "dimensions", false, JcrConstants.NT_UNSTRUCTURED, JcrConstants.NT_UNSTRUCTURED, true);
        dimensions.setProperty("jcr:title", "Dimensions");
        JcrUtils.getOrCreateByPath(dimensions , "height" , false , JcrConstants.NT_UNSTRUCTURED, JcrConstants.NT_UNSTRUCTURED, true);
        JcrUtils.getOrCreateByPath(dimensions , "width" , false , JcrConstants.NT_UNSTRUCTURED, JcrConstants.NT_UNSTRUCTURED, true);
        JcrUtils.getOrCreateByPath(dimensions , "depth" , false , JcrConstants.NT_UNSTRUCTURED, JcrConstants.NT_UNSTRUCTURED, true);
        JcrUtils.getOrCreateByPath(classifications, classificationName, false, JcrConstants.NT_UNSTRUCTURED, JcrConstants.NT_UNSTRUCTURED, true);
    }

}
