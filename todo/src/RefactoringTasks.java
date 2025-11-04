import org.apache.ofbiz.base.component.ComponentConfig;
import org.apache.ofbiz.base.component.ComponentLoaderConfig;
import org.apache.ofbiz.base.concurrent.ConstantFuture;
import org.apache.ofbiz.base.config.ResourceLoader;
import org.apache.ofbiz.base.container.AdminServerContainer;
import org.apache.ofbiz.base.conversion.Converter;
import org.apache.ofbiz.base.conversion.Converters;
import org.apache.ofbiz.base.html.SanitizerCustomPolicy;
import org.apache.ofbiz.base.start.Config;
import org.apache.ofbiz.base.util.*;
import org.apache.ofbiz.base.util.collections.FlexibleServletAccessor;
import org.apache.ofbiz.base.util.collections.GenericMap;
import org.apache.ofbiz.base.util.collections.GenericMapEntry;
import org.apache.ofbiz.base.util.collections.MapContext;
import org.apache.ofbiz.common.FindServices;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.DelegatorFactory;
import org.apache.ofbiz.entity.GenericEntity;
import org.apache.ofbiz.entity.condition.EntityComparisonOperator;
import org.apache.ofbiz.entity.condition.EntityConditionVisitor;
import org.apache.ofbiz.entity.condition.EntityFieldMap;
import org.apache.ofbiz.entity.config.model.JdbcElement;
import org.apache.ofbiz.entity.connection.DBCPConnectionFactory;
import org.apache.ofbiz.entity.connection.DebugManagedDataSource;
import org.apache.ofbiz.entity.datasource.GenericHelperInfo;
import org.apache.ofbiz.entity.finder.EntityFinderUtil;
import org.apache.ofbiz.entity.jdbc.AbstractCursorHandler;
import org.apache.ofbiz.entity.model.*;
import org.apache.ofbiz.entity.serialize.XmlSerializer;
import org.apache.ofbiz.entity.transaction.TransactionUtil;
import org.apache.ofbiz.security.SecuredUpload;
import org.apache.ofbiz.service.GenericServiceCallback;
import org.apache.ofbiz.service.ModelService;
import org.apache.ofbiz.service.ServiceDispatcher;
import org.apache.ofbiz.webapp.AfterLoginEvents;
import org.apache.ofbiz.webapp.control.RequestHandler;
import org.apache.ofbiz.webapp.event.CoreEvents;
import org.apache.ofbiz.webapp.ftl.OfbizCurrencyTransform;
import org.apache.ofbiz.webapp.ftl.OfbizNumberTransform;
import org.apache.ofbiz.widget.model.ModelForm;
import org.apache.ofbiz.widget.renderer.FormRenderer;
import org.apache.ofbiz.widget.renderer.Paginator;
import org.apache.ofbiz.widget.renderer.html.HtmlWidgetRenderer;
import org.apache.ofbiz.widget.renderer.macro.renderable.RenderableFtl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.transaction.Transaction;
import java.io.PrintWriter;
import java.net.URL;
import java.util.*;
import java.util.function.*;

/**
 * Hearty welcome to the course on Refactoring to Java 25. We will look at all
 * the interesting features from Java 11 onwards. If you are already using a
 * later Java version and you are completely familiar with the features, you can
 * skip ahead. But perhaps try do the refactorings first.
 *
 * IRL when we refactor, we need a comprehensive set of unit tests to ensure
 * that we do not accidentally introduce bugs into the code. As the old adage
 * goes: "If something ain't broke, don't fix it." For this course, we will not
 * worry about unit tests, and might just occasionally make sure that OfBiz
 * still runs.
 *
 * We need (at least) Java 25 for this course, as well as IntelliJ Community or
 * Ultimate. To compile and run the code, we can use ./gradlew clean ofbiz
 *
 * We will study each new feature in turn by looking through the published
 * JEP (JDK Enhancement Proposal), then you can do some refactoring exercises.
 * Once you have tried yourself, you can look at my walkthrough.
 *
 * You are welcome to use AI tools for the refactoring exercises, but do check
 * that the result is what you are happy with.
 *
 * Please ask questions in the comments section.
 */
public class RefactoringTasks {
    public static void main(String... args) {
        System.out.println("Enjoy the refactoring!");
    }

    /**
     * 1. Replace local variable declarations with "var" (Java 10 & 11, JEPs 286 & 323)
     * <p>
     * Description: Even though this is quite an old feature, it is not used
     * much in the JDK. An argument that we have heard is that we might want to
     * use it all the time for *all* local variables, because that will force us
     * to come up with better variable names. In other words, if you do *not*
     * use "var", you will have to persuade your colleagues why not. In this
     * refactoring, we will just change two methods, but there are almost
     * 30,000 other variables we could replace.
     * <p>
     * {@link ModelFieldTypeReader#createFieldTypeCache(Element, String)}
     * {@link FormRenderer#renderHeaderRow(Appendable, Map)}
     *
     */
    public static void task1_localVariableVar() {
    }

    /**
     * 2. String.repeat() can be used (Java 11, no JEP)
     * <p>
     * Description: This is an easy one, when we have a String made of the same
     * repeating characters, we should use String.repeat() instead.
     * <p>
     * {@link GenericEntity#writeXmlText(PrintWriter, String)}
     * {@link UtilTimer#timerString(int, String)}
     */
    public static void task2_StringRepeat() {
        System.out.println("-:".repeat(10));
    }

    /**
     * 3. Replace old style switch with switch expressions (Java 14, JEP 361)
     * <p>
     * Description: We want to first of all change switch statements to switch
     * expressions, where possible. We then want to change the old style switch
     * to the new type. This will hopefully help eliminate common bugs that
     * occur when we forget to add a break in a case statement. The old style
     * switch was a leftover from the C language. When Java was invented, they
     * made it too similar to C, in order to win over the hearts and minds of
     * the real geeks.
     * <p>
     * {@link ComponentLoaderConfig.ComponentDef#of(Element, URL)}
     * {@link Config#getDefaultLocale(Properties, String)}
     * {@link SSLUtil#getHostnameVerifier(int)}
     * {@link TransactionUtil#getTransactionStateString(int)}
     * {@link HtmlWidgetRenderer#beginNamedBorder(String, String, String)}
     */
    public static void task3_switchExpressions() {
        // Done some by OpenRewrite
    }

    /**
     * 4. Replace fragmented Strings with Text Blocks (Java 15, JEP 378)
     * <p>
     * Description: Instead of having Strings with \n, we can use text blocks
     * to make them more readable. With text blocks, we also do not have to
     * escape the " characters.
     * <p>
     * {@link AfterLoginEvents}
     * {@link ScriptUtil#isSafeScript(String, String)}
     * {@link UtilNumber#RULE_SET_EN_US}
     * {@link UtilNumber#RULE_SET_EN_IN}
     * {@link UtilNumber#RULE_SET_TH_TH}
     */
    public static void task4_textBlocks() {
        // Done by OpenRewrite
    }

    /**
     * 5. Replace simple data classes with records (Java 16, JEP 395)
     * <p>
     * Description: Records simplify simple data classes. All fields are final
     * and there is additional protection against modification with deep
     * reflection vs normal classes. Records themselves are also final. They
     * cannot extend other classes, but they can implement interfaces. Since
     * records have accessor methods for all their fields, this might break
     * encapsulation for some of these classes. Once they are records, they can
     * also be used for pattern deconstruction.
     * <p>
     * {@link ModelKeyMap}
     * {@link ConstantFuture}
     * {@link Converters.PassThruConverter}
     * {@link DelegatorFactory.DelegatorConfigurable}
     * {@link GenericMapEntry}
     * {@link ModelInfo}
     * {@link ModelViewEntity.ModelMemberEntity}
     * {@link ModelViewEntity.ModelAliasAll} (more difficult)
     * {@link ScriptUtil.ProtectedBindings}
     * {@link ModelService.ModelServiceMapEntry}
     */
    public static void task5_replaceDataClassesWithRecords() {
    }

    /**
     * 6. Pattern Matching for instanceof (Java 16, JEP 394)
     * <p>
     * Description: This is the first of many patterns and allows us to declare
     * a local variable when we check a type with instanceof. Instead of an
     * instanceof, followed by a cast, we can let the pattern matching cast for
     * us.
     * <p>
     * {@link CoreEvents#getObjectFromServicePath(String, Map)}
     * {@link EntityFinderUtil#expandFieldMapToContext(Map, Map, Map)}
     * {@link GenericMap#equals(Object)}
     * {@link ModelUtil#isPotentialLocalizedFields(ModelEntity, List)}
     * {@link FlexibleServletAccessor#equals(Object)}
     * {@link EntityComparisonOperator#validateSql(ModelEntity, Object, Object)} (and others)
     * {@link DBCPConnectionFactory#getConnection(GenericHelperInfo, JdbcElement)}
     * {@link DebugManagedDataSource#getConnection()}
     */
    public static void task6_patternMatchingForInstanceof() {
        // Done by OpenRewrite
    }

    /**
     * 7. Tighten up hierarchies with sealed classes (Java 17, JEP 409)
     * <p>
     * Description: One of my favourite features is sealed classes in that it
     * allows us to specify exactly what subclasses are allowed. A type can now
     * be sealed and then sub-types can be either final, sealed or non-sealed.
     * This prevents unexpected subclasses from appearing. By doing these
     * exercises, we will discover some errors in the original code.
     * <p>
     * {@link ResourceLoader}
     * {@link AbstractCursorHandler}
     * {@link SanitizerCustomPolicy}
     * {@link Converter}
     * {@link RenderableFtl}
     * {@link ModelViewEntity.ComplexAliasMember}
     */
    public static void task7_sealedClasses() {
    }


    /**
     * 8. Code Snippets in Java API Documentation (Java 18, JEP 413)
     * <p>
     * Description: Instead of a "pre" tag, we can add Java code snippets with:
     * {@snippet :
     *   for(int i = 0; i < 10; i++) System.out.println(i);
     *}
     * <p>
     * {@link EntityConditionVisitor}
     * {@link ScriptHelper}
     */
    public static void task8_codeSnippetsInAPIDocumentation() {
    }

    /**
     * 9. Use sequenced collection method instead (Java 21, JEP 431)
     * <p>
     * Description: List, Deque and some of the Sets now are also
     * SequencedCollection, which means that we can access the first and last
     * elements, and sometimes also add and remove from both ends. This brings
     * order to methods, where before we would have to either call get(0) to get
     * the first element of a List, or getFirst() for a Deque. The sequenced
     * collections have a unified getFirst() method. Similarly to get the last
     * element, a List needed get(list.size() - 1), whereas now we can simply
     * call getLast().
     * <p>
     * {@link ModelEntity#getOnlyPk()}
     * {@link ModelEntity#createEoModelMap(String, String, Set, ModelReader)}
     * {@link RequestHandler#getRequestUri(String) (4x)}
     * {@link TransactionUtil#pushSuspendedTransaction(Transaction)}
     * {@link TransactionUtil#popSuspendedTransaction()}
     * {@link UtilProperties.UtilResourceBundle#getBundle(String, Locale, ClassLoader)}
     */
    public static void task9_sequencedCollections() {
        // Done by OpenRewrite
    }

    /**
     * 10. Record Patterns (Java 21, JEP 440)
     * <p>
     * Description: We can deconstruct the patterns into their own components
     * with record patterns. We did not find that many use cases in our code,
     * since we do not use that many records, except for the equals() methods.
     * <p>
     * {@link ModelKeyMap#equals(Object)}
     * {@link ModelService.ModelServiceMapEntry#equals(Object)}
     */
    public static void task10_recordPatterns() {
    }

    /**
     * 11. Pattern Matching for switch (Java 21, JEP 441)
     * <p>
     * Description: Instead of individual instanceof checks, we can also use
     * this type of pattern matching inside switch. It pairs nicely with sealed
     * classes.
     * <p>
     * {@link OfbizCurrencyTransform#getInteger(Map, String)}
     * {@link OfbizNumberTransform#getNumber(Map, String)}
     * {@link Paginator#getListLimits(ModelForm, Map, Object)}
     * {@link XmlSerializer#serializeSingle(Object, Document)}
     */
    public static void task11_patternMatchingForSwitch() {
    }

    /**
     * 12. Unnamed Variables & Patterns (Java 22, JEP 456)
     * <p>
     * Description: In Java 9, _ became a reserved keyword, and we were no
     * longer allowed to use it as a variable name. We can now use it for
     * unnused lambda parameters and for record deconstruction components.
     * <p>
     * {@link FindServices#createConditionList(Map, List, Map, Delegator, Map, String)}
     * {@link MapContext#size()}
     * {@link ServiceDispatcher#registerCallback(String, GenericServiceCallback)}
     *
     * Also revisit some old code:
     * {@link ModelKeyMap#equals(Object)}
     * {@link XmlSerializer#serializeSingle(Object, Document)}
     */
    public static void task12_unnamedVariablesPatterns() {
        // Done by OpenRewrite
    }

    /**
     * 13. Stream Gatherers (Java 24, JEP 485)
     * <p>
     * Description: This construct brings more flexibility to intermediate
     * operations, for example to handle exceptions in the middle of a stream,
     * or to allow more sophisticated processing of state.
     *
     * @see ComponentConfig#collectElements(Element, String, BiFunction)  (maybe)
     * @see ModelService#allowHtmlValidation(Map, Map, Locale)
     */
    public static void task13_streamGatherers() {
    }

    /**
     * 14. Flexible Constructor Bodies (Java 25, JEP 513)
     * <p>
     * Description: In the past, we could not have any code before the call to
     * super() inside a constructor. This meant that we could not assign any
     * fields before calling super(), nor could we do sanity checking of the
     * parameters. This is now changed in Java 25.
     *
     * @see EntityFieldMap constructors
     * @see DateRange constructor
     */
    public static void task14_flexibleConstructorBodies() {
    }

    /**
     * 15. Compact Source Files and Instance Main Methods (Java 25, JEP 512)
     * <p>
     * Description: This feature is mainly for demos, where a class is not in a
     * package and we want to minimize boilerplate code. They also replaced
     * System.out with IO. The following is thus valid Java code:
     * {@snippet :
     * // Inside Demo.java
     * void main() { IO.println("Hello World!"); }
     *}
     * We cannot use the compact classes, since all our classes are inside
     * packages. However, we can replace System.out with IO.
     * <p>
     * {@link AdminServerContainer#init(List, String, String)}
     * {@link AdminServerContainer#run()}
     */
    public static void task15_compactSourceFiles() {
        // Done by OpenRewrite
    }

    /**
     * 16. Module Import Declarations (Java 25, JEP 511)
     * <p>
     * Description: Instead of importing a bunch of individual classes and
     * packages, we can inport entire modules. We have to be careful of
     * ambiguity, for example with java.util.Date and java.sql.Date.
     *
     * @see ComponentConfig // java.base and java.xml
     * @see SecuredUpload // java.base and java.desktop
     * @see ModelService
     * @see UtilHttp
     */
    public static void task16_moduleImportDeclarations() {
    }

    // IGNORE - just to help IntelliJ find the classes :-)
    static {
        AbstractCursorHandler abstractCursorHandler;
        AdminServerContainer adminServerContainer;
        AfterLoginEvents afterLoginEvents;
        ComponentConfig componentConfig;
        ComponentLoaderConfig.ComponentDef componentLoaderConfigComponentDef;
        Config config;
        ConstantFuture constantFuture;
        Converter converter;
        Converters converters;
        CoreEvents coreEvents;
        DBCPConnectionFactory dBCPConnectionFactory;
        DebugManagedDataSource debugManagedDataSource;
        DelegatorFactory.DelegatorConfigurable delegatorFactoryDelegatorConfigurable;
        EntityComparisonOperator entityComparisonOperator;
        EntityConditionVisitor entityConditionVisitor;
        EntityFinderUtil entityFinderUtil;
        FindServices findServices;
        FlexibleServletAccessor flexibleServletAccessor;
        FormRenderer formRenderer;
        GenericEntity genericEntity;
        GenericMap genericMap;
        GenericMapEntry genericMapEntry;
        HtmlWidgetRenderer htmlWidgetRenderer;
        MapContext mapContext;
        ModelEntity modelEntity;
        ModelFieldTypeReader modelFieldTypeReader;
        ModelInfo modelInfo;
        ModelKeyMap modelKeyMap;
        ModelService modelService;
        ModelUtil modelUtil;
        ModelViewEntity.ComplexAliasMember modelViewEntityComplexAliasMember;
        ModelViewEntity.ModelAliasAll modelViewEntityModelAliasAll;
        ModelViewEntity.ModelMemberEntity modelViewEntityModelMemberEntity;
        OfbizCurrencyTransform ofbizCurrencyTransform;
        OfbizNumberTransform ofbizNumberTransform;
        Paginator paginator;
        RenderableFtl renderableFtl;
        RequestHandler requestHandler;
        ResourceLoader resourceLoader;
        SanitizerCustomPolicy sanitizerCustomPolicy;
        ScriptHelper scriptHelper;
        ScriptUtil scriptUtil;
        ServiceDispatcher serviceDispatcher;
        SSLUtil sSLUtil;
        TransactionUtil transactionUtil;
        UtilHttp utilHttp;
        UtilNumber utilNumber;
        UtilProperties.UtilResourceBundle utilPropertiesUtilResourceBundle;
        UtilTimer utilTimer;
        XmlSerializer xmlSerializer;
    }
}