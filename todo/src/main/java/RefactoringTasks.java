import org.apache.ofbiz.entity.model.ModelEntity;
import org.apache.ofbiz.entity.model.ModelReader;
import org.apache.ofbiz.base.component.ComponentLoaderConfig;
import org.apache.ofbiz.base.concurrent.ConstantFuture;
import org.apache.ofbiz.base.conversion.Converters;
import org.apache.ofbiz.base.start.Config;
import org.apache.ofbiz.base.util.collections.FlexibleServletAccessor;
import org.apache.ofbiz.base.util.collections.GenericMap;
import org.apache.ofbiz.base.util.collections.GenericMapEntry;
import org.apache.ofbiz.base.util.ScriptHelper;
import org.apache.ofbiz.base.util.ScriptUtil;
import org.apache.ofbiz.base.util.SSLUtil;
import org.apache.ofbiz.base.util.UtilNumber;
import org.apache.ofbiz.base.util.UtilProperties;
import org.apache.ofbiz.base.util.UtilTimer;
import org.apache.ofbiz.entity.condition.EntityComparisonOperator;
import org.apache.ofbiz.entity.condition.EntityConditionVisitor;
import org.apache.ofbiz.entity.DelegatorFactory;
import org.apache.ofbiz.entity.finder.EntityFinderUtil;
import org.apache.ofbiz.entity.GenericEntity;
import org.apache.ofbiz.entity.jdbc.AbstractCursorHandler;
import org.apache.ofbiz.entity.model.ModelFieldTypeReader;
import org.apache.ofbiz.entity.model.ModelInfo;
import org.apache.ofbiz.entity.model.ModelUtil;
import org.apache.ofbiz.entity.model.ModelViewEntity;
import org.apache.ofbiz.entity.transaction.TransactionUtil;
import org.apache.ofbiz.webapp.AfterLoginEvents;
import org.apache.ofbiz.webapp.control.RequestHandler;
import org.apache.ofbiz.webapp.event.CoreEvents;
import org.apache.ofbiz.widget.renderer.FormRenderer;

import org.w3c.dom.Element;

import java.util.*;
import javax.transaction.Transaction;

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
     */
    public static void task6_patternMatchingForInstanceof() {
    }

    /**
     * // Java 17
     * Tighten up hierarchies with sealed classes - JEP 409
     * {@link AbstractCursorHandler}
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
     * REFACTOR: Pattern Matching for switch - JEP 441
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
     * @see ExecutionPool (maybe)
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
     */
    public static void task16_flexibleConstructorBodies() {
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
     */
    public static void task18_moduleImportDeclarations() {
    }

    /**
     * // Java 25
     * REFACTOR: Scoped Values - JEP 506
     */
    public static void task19_scopedValues() {
    }
}