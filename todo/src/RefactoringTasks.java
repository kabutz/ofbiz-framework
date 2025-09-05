import org.apache.ofbiz.base.component.ComponentConfig;
import org.apache.ofbiz.base.component.ComponentLoaderConfig;
import org.apache.ofbiz.base.concurrent.ConstantFuture;
import org.apache.ofbiz.base.config.ResourceLoader;
import org.apache.ofbiz.base.conversion.Converter;
import org.apache.ofbiz.base.conversion.Converters;
import org.apache.ofbiz.base.html.SanitizerCustomPolicy;
import org.apache.ofbiz.base.start.Config;
import org.apache.ofbiz.base.util.*;
import org.apache.ofbiz.base.util.collections.FlexibleServletAccessor;
import org.apache.ofbiz.base.util.collections.GenericMap;
import org.apache.ofbiz.base.util.collections.GenericMapEntry;
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
import org.apache.ofbiz.service.ModelService;
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
        506: Scoped Values
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
     * {@link ModelFieldTypeReader#createFieldTypeCache(Element, String)}
     * {@link FormRenderer#renderHeaderRow(Appendable, Map)}
     *
     */
    public static void task1_localVariableVar() {
    }

    /**
     * // Java 11
     * String.repeat() can be used
     * {@link GenericEntity#writeXmlText(PrintWriter, String)}
     * {@link UtilTimer#timerString(int, String)}
     */
    public static void task2_StringRepeat() {
        System.out.println("-:".repeat(10));
    }

    /**
     * // Java 14
     * Replace old style switch with switch expressions (Standard) - JEP 361
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
     * {@link ConstantFuture}
     * {@link Converters.PassThruConverter}
     * {@link DelegatorFactory.DelegatorConfigurable}
     * {@link GenericMapEntry}
     * {@link ModelInfo}
     * {@link ModelViewEntity.ModelMemberEntity}
     * {@link ModelViewEntity.ModelAliasAll} (more difficult)
     * {@link ScriptUtil.ProtectedBindings}
     */
    public static void task5_replaceDataClassesWithRecords() {
    }

    /**
     * // Java 16
     * Pattern Matching for instanceof - JEP 394
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
     * {@link EntityConditionVisitor}
     * {@link ScriptHelper}
     */
    public static void task8_codeSnippetsInAPIDocumentation() {
    }

    /**
     * // Java 21
     * Use sequenced collection method instead - JEP 431
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
     * REFACTOR: Record Patterns - JEP 440
     */
    public static void task10_recordPatterns() {
    }

    /**
     * // Java 21
     * Pattern Matching for switch - JEP 441
     * {@link OfbizCurrencyTransform#getInteger(Map, String)}
     * {@link OfbizNumberTransform#getNumber(Map, String)}
     * {@link Paginator#getListLimits(ModelForm, Map, Object)}
     * {@link XmlSerializer#serializeSingle(Object, Document)}
     */
    public static void task11_patternMatchingForSwitch() {

    }

    /**
     * // Java 21
     * REFACTOR: Virtual Threads - JEP 444
     *
     * @see ExecutionPool (maybe)
     */
    public static void task12_virtualThreads() {
    }

    /**
     * // Java 22
     * REFACTOR: Foreign Function & Memory API - JEP 454
     *
     */
    public static void task13_foreignFunctionMemoryAPI() {
    }

    /**
     * // Java 22
     * REFACTOR: Unnamed Variables & Patterns - JEP 456
     *
     * @see ExecutionPool (maybe)
     */
    public static void task14_unnamedVariablesPatterns() {
    }

    /**
     * // Java 24
     * REFACTOR: Stream Gatherers - JEP 485
     *
     * @see ComponentConfig#collectElements(Element, String, BiFunction)  (maybe)
     * @see ModelService#allowHtmlValidation(Map, Map, Locale)
     */
    public static void task15_streamGatherers() {
    }

    /**
     * // Java 25
     * REFACTOR: Flexible Constructor Bodies - JEP 513
     * @see EntityFieldMap constructors
     */
    public static void task16_flexibleConstructorBodies() {
        EntityFieldMap entityFieldMap;
    }

    /**
     * // Java 25
     * REFACTOR: Compact Source Files and Instance Main Methods - JEP 512
     */
    public static void task17_compactSourceFiles() {
    }

    /**
     * // Java 25
     * REFACTOR: Module Import Declarations - JEP 511
     *
     * @see ComponentConfig // java.base and java.xml
     * @see SecuredUpload // java.base and java.desktop
     * @see ModelService
     * @see UtilHttp
     */
    public static void task18_moduleImportDeclarations() {
    }

    /**
     * // Java 25
     * REFACTOR: Scoped Values - JEP 506
     */
    public static void task19_scopedValues() {
    }

    // IGNORE - just to help IntelliJ find the classes :-)
    static {
        UtilHttp utilHttp;
        BiFunction biFunction;
        ModelService modelService;
        ComponentConfig componentConfig;
        SecuredUpload securedUpload;

    }
}