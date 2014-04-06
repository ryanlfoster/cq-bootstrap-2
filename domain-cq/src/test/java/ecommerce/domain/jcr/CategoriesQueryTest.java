package ecommerce.domain.jcr;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.eval.PathPredicateEvaluator;
import com.day.cq.search.eval.TypePredicateEvaluator;
import com.day.cq.search.impl.builder.QueryBuilderImpl;
import com.day.cq.search.result.SearchResult;
import com.day.crx.sling.testing.RepositoryBaseTest;
import org.apache.jackrabbit.JcrConstants;
import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.jackrabbit.commons.cnd.CndImporter;
import org.apache.jackrabbit.commons.cnd.ParseException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.jcr.api.SlingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.nodetype.NodeType;
import javax.jcr.nodetype.NodeTypeManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CategoriesQueryTest extends RepositoryBaseTest {

    private static final Logger log = LoggerFactory.getLogger(CategoriesQueryTest.class);
    public static final String SLING_FOLDER = "sling:Folder";
    private Session login;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        final SlingRepository repository = getRepository();
        login = repository.login(new SimpleCredentials("admin", "admin".toCharArray()));
        setNodeTypes(login);
        createProductCatalog(login);
        createProductInformtion(login);
    }

    @Override
    public void tearDown() throws Exception {
        tearDownTheRepository(login);
        login.logout();
        super.tearDown();
    }

    public void testTheQueryWeBuildFindsTheCorrectNumberOfSlingFolders() throws Exception {

        QueryBuilder queryBuilder = stubbedQueryBuilder();
        Map<String, String> predicateParameterMap = createTheQuery();
        SearchResult result = runTheQuery(login, queryBuilder, predicateParameterMap);
        int NUMBER_OF_SLING_FOLDERS_FOUND_IN_THE_SHOP = 24;
        assertThat(result.getHits().size(), equalTo(NUMBER_OF_SLING_FOLDERS_FOUND_IN_THE_SHOP));
        Iterator<Resource> resources = result.getResources();
        while (resources.hasNext()) {
            log.debug(resources.next().getPath());
        }

    }

    private void tearDownTheRepository(Session login) throws RepositoryException {
        login.getRootNode().getNode("etc/commerce").remove();
        login.save();
    }

    private SearchResult runTheQuery(Session login, QueryBuilder queryBuilder, Map<String, String> predicateParameterMap) {
        Query query = queryBuilder.createQuery(PredicateGroup.create(predicateParameterMap), login);
        query.setHitsPerPage(100);
        return query.getResult();
    }

    private Map<String, String> createTheQuery() {
        Map<String, String> predicateParameterMap = new HashMap<String, String>();

        predicateParameterMap.put("path", "/etc/commerce/products/aol/aolProductCatalog/en/shop");
        predicateParameterMap.put("type", SLING_FOLDER);
        predicateParameterMap.put("p.nodedepth", "1");
        predicateParameterMap.put("p.limit", "-1");
        return predicateParameterMap;
    }

    private void setNodeTypes(Session login) throws RepositoryException, ParseException, IOException {
        NodeTypeManager nodeTypeManager = login.getWorkspace().getNodeTypeManager();

        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("all_node_types.txt");

        NodeType[] nodeTypes = CndImporter.registerNodeTypes(new InputStreamReader(resourceAsStream), login);

        nodeTypeManager.registerNodeTypes(nodeTypes, true);
    }

    private void createProductInformtion(Session login) throws RepositoryException {
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
                "bbq"
        );
    }


    private void createProductCatalog(Session login) throws RepositoryException {
        Node etc = JcrUtils.getOrCreateByPath("/etc", SLING_FOLDER, SLING_FOLDER, login, true);

        Node commerce = JcrUtils.getOrCreateByPath(etc, "commerce", false, SLING_FOLDER, SLING_FOLDER, true);
        Node products = JcrUtils.getOrCreateByPath(commerce, "products", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        Node aol = JcrUtils.getOrCreateByPath(products, "aol", false, SLING_FOLDER, JcrConstants.NT_UNSTRUCTURED, true);
        Node aolPrductCatalog = JcrUtils.getOrCreateByPath(aol, "aolProductCatalog", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        Node en = JcrUtils.getOrCreateByPath(aolPrductCatalog, "en", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        Node shop = JcrUtils.getOrCreateByPath(en, "shop", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);

        Node bbq = JcrUtils.getOrCreateByPath(shop, "bbq", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        JcrUtils.getOrCreateByPath(bbq, "bbq-bbq", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        JcrUtils.getOrCreateByPath(bbq, "bbq-bbqRangehood", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);

        Node cooking = JcrUtils.getOrCreateByPath(shop, "cooking", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        JcrUtils.getOrCreateByPath(cooking, "cooking-accessories", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        JcrUtils.getOrCreateByPath(cooking, "cooking-cooker", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        JcrUtils.getOrCreateByPath(cooking, "cooking-cooktops", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        JcrUtils.getOrCreateByPath(cooking, "cooking-deepFryer", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);


        JcrUtils.getOrCreateByPath(cooking, "cooking-electricFryPanAndWok", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        Node cooking_ovens = JcrUtils.getOrCreateByPath(cooking, "cooking-ovens", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);


        Node cooking_ovens_builtInOven = JcrUtils.getOrCreateByPath(cooking_ovens, "cooking-ovens-builtInOven", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        JcrUtils.getOrCreateByPath(cooking_ovens_builtInOven, "cooking-ovens-builtInOven-combination", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        JcrUtils.getOrCreateByPath(cooking_ovens_builtInOven, "cooking-ovens-builtInOven-conventional", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        JcrUtils.getOrCreateByPath(cooking_ovens_builtInOven, "cooking-ovens-builtInOven-fanOven", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        JcrUtils.getOrCreateByPath(cooking_ovens_builtInOven, "cooking-ovens-builtInOven-multiFunction", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        JcrUtils.getOrCreateByPath(cooking_ovens_builtInOven, "cooking-ovens-builtInOven-steam", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);


        JcrUtils.getOrCreateByPath(cooking, "cooking-rangehoods", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        JcrUtils.getOrCreateByPath(cooking, "cooking-stoves", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);

        JcrUtils.getOrCreateByPath(shop, "dishWasherAndSink", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        JcrUtils.getOrCreateByPath(shop, "fridgeAndFreezer", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        JcrUtils.getOrCreateByPath(shop, "heatingAndCooling", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        JcrUtils.getOrCreateByPath(shop, "smallAppliances", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        JcrUtils.getOrCreateByPath(shop, "tvAndAudio", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
        JcrUtils.getOrCreateByPath(shop, "washerAndDryer", false, JcrConstants.NT_UNSTRUCTURED, SLING_FOLDER, true);
    }

    private QueryBuilderImpl stubbedQueryBuilder() {
        return new QueryBuilderImpl() {

            @Override
            public ResourceResolver createResourceResolver(Session session) {
                return getResolverFactory().getResourceResolver(session);
            }

            @Override
            public <ComponentT> ComponentT getComponent(Class<ComponentT> typeClass, String type, Dictionary properties) {

                if("path".equalsIgnoreCase(type))
                    return (ComponentT) new PathPredicateEvaluator();
                if("type".equals(type))
                    return (ComponentT) new TypePredicateEvaluator();
                return null;
            }
        };
    }

    private void setupNode(Node product, String[] categories, String code, String hybrisProductId, String[] cqTags, String jcrTitle, String description, String sku, String summary, String url, final String classificationName) throws RepositoryException {
        product.setProperty("categories", categories);
        product.setProperty("code", code);
        product.setProperty("cq:commerceType", "product");
        product.setProperty("cq:hybrisProductId", hybrisProductId);
        product.setProperty("cq:tags", cqTags);
        product.setProperty("jcr:title", jcrTitle);
        product.setProperty("description", description);
        product.setProperty("purchasable", true);
        product.setProperty("sku", sku);
        product.setProperty("sling:resourceType", "commerce/components/product");
        product.setProperty("summary", summary);
        product.setProperty("url", url);

        Node classifications = JcrUtils.getOrCreateByPath(product, "classifications", false, JcrConstants.NT_UNSTRUCTURED, JcrConstants.NT_UNSTRUCTURED, true);
        Node dimensions = JcrUtils.getOrCreateByPath(classifications, "dimensions", false, JcrConstants.NT_UNSTRUCTURED, JcrConstants.NT_UNSTRUCTURED, true);
        dimensions.setProperty("jcr:title", "Dimensions");
        JcrUtils.getOrCreateByPath(dimensions, "height", false, JcrConstants.NT_UNSTRUCTURED, JcrConstants.NT_UNSTRUCTURED, true);
        JcrUtils.getOrCreateByPath(dimensions, "width", false, JcrConstants.NT_UNSTRUCTURED, JcrConstants.NT_UNSTRUCTURED, true);
        JcrUtils.getOrCreateByPath(dimensions, "depth", false, JcrConstants.NT_UNSTRUCTURED, JcrConstants.NT_UNSTRUCTURED, true);

        JcrUtils.getOrCreateByPath(classifications, classificationName, false, JcrConstants.NT_UNSTRUCTURED, JcrConstants.NT_UNSTRUCTURED, true);
    }

}


interface CategoryQuery {
    public void run();
}

class CQCategoryQuery implements CategoryQuery {


    private QueryBuilder queryBuilder;
    private Session session;

    public static final String SLING_FOLDER = "sling:Folder";

    public CQCategoryQuery(QueryBuilder queryBuilder, Session session) {
        this.queryBuilder = queryBuilder;
        this.session = session;
    }

    private Map<String, String> createTheQuery() {
        Map<String, String> predicateParameterMap = new HashMap<String, String>();

        predicateParameterMap.put("path", "/etc/commerce/products/aol/aolProductCatalog/en/shop");
        predicateParameterMap.put("type", SLING_FOLDER);
        predicateParameterMap.put("p.nodedepth", "1");
        return predicateParameterMap;
    }

    public SearchResult execute(){
        return queryBuilder.createQuery(PredicateGroup.create(createTheQuery()), session).getResult();
    }

    public void run(){
        SearchResult execute = execute();
        Iterator<Resource> resources = execute.getResources();
        while(resources.hasNext()){
            Resource resource = resources.next();
            log.trace(resource.getPath());
        }
    }

    private static final Logger log = LoggerFactory.getLogger(CQCategoryQuery.class);
}
