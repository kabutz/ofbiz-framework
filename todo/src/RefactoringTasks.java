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

public class RefactoringTasks {
    public static void main(String... args) {
        System.out.println("Enjoy the refactoring!");
    }

    /*
    Java25:
        511: Module Import Declarations
        512: Compact Source Files and Instance Main Methods
        513: Flexible Constructor Bodies
    Java24:
        485: Stream Gatherers
    Java23:
        467: Markdown Documentation Comments
    Java22:
        454: Foreign Function & Memory API
        456: Unnamed Variables & Patterns
    Java21:
        431: Sequenced Collections
        440: Record Patterns
        441: Pattern Matching for switch
        444: Virtual Threads
    Java18:
        413: Code Snippets in Java API Documentation
    Java17:
        409: Sealed Classes
    Java16:
        394: Pattern Matching for instanceof
        395: Records
    Java15:
        378: Text Blocks
    Java14:
        361: Switch Expressions (Standard)
    Java11:
        // 321: HTTP Client (Standard)
        // 323: Local-Variable Syntax for Lambda Parameters
        String.repeat() can be used
     */

    /**
     * // Java 10 & 11
     * Replace all the local variable declarations with "var" (JEP 286 and 323)
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
     * // Java 11
     * String.repeat() can be used
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
     * // Java 14
     * Replace old style switch with switch expressions (Standard) - JEP 361
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
    }

    /**
     * // Java 15
     * Replace fragmented Strings with Text Blocks - JEP 378
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
    }

    /**
     * // Java 16
     * Replace simple data classes with records - JEP 395
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
     * // Java 16
     * Pattern Matching for instanceof - JEP 394
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

    }

    /**
     * // Java 17
     * Tighten up hierarchies with sealed classes - JEP 409
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
     * // Java 18
     * Code Snippets in Java API Documentation - JEP 413
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
     * // Java 21
     * Use sequenced collection method instead - JEP 431
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
    }

    /**
     * // Java 21
     * Record Patterns - JEP 440
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
     * // Java 21
     * Pattern Matching for switch - JEP 441
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
     * // Java 22
     * Unnamed Variables & Patterns - JEP 456
     *
     * {@link FindServices#createConditionList(Map, List, Map, Delegator, Map, String)} #size()}
     * {@link MapContext#size()}
     * {@link ServiceDispatcher#registerCallback(String, GenericServiceCallback)}
     */
    public static void task12_unnamedVariablesPatterns() {
    }

    /**
     * // Java 24
     * Stream Gatherers - JEP 485
     *
     * @see ComponentConfig#collectElements(Element, String, BiFunction)  (maybe)
     * @see ModelService#allowHtmlValidation(Map, Map, Locale)
     */
    public static void task13_streamGatherers() {
    }

    /**
     * // Java 25
     * Flexible Constructor Bodies - JEP 513
     *
     * @see EntityFieldMap constructors
     * @see DateRange constructor
     */
    public static void task14_flexibleConstructorBodies() {
    }

    /**
     * // Java 25
     * Compact Source Files and Instance Main Methods - JEP 512
     * {@link AdminServerContainer#init(List, String, String)}
     * {@link AdminServerContainer#run()}
     */
    public static void task15_compactSourceFiles() {
    }

    /**
     * // Java 25
     * Module Import Declarations - JEP 511
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