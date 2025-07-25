import org.apache.ofbiz.entity.config.model.Datasource;
import org.apache.ofbiz.entity.model.ModelEntity;
import org.w3c.dom.Element;

import java.io.PrintWriter;
import java.net.URL;
import java.util.*;

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
     * {@link org.apache.ofbiz.entity.model.ModelFieldTypeReader#createFieldTypeCache(Element, String)}
     * {@link org.apache.ofbiz.widget.renderer.FormRenderer#renderHeaderRow(Appendable, Map)}
     *
     */
    public static void task1_localVariableVar() {
    }

    /**
     * // Java 11
     * String.repeat() can be used
     * {@link org.apache.ofbiz.entity.GenericEntity#writeXmlText(PrintWriter, String)}
     * {@link org.apache.ofbiz.base.util.UtilTimer#timerString(int, String)}
     */
    public static void task2_StringRepeat() {
        System.out.println("-:".repeat(10));
    }

    /**
     * // Java 14
     * Replace old style switch with switch expressions (Standard) - JEP 361
     * {@link org.apache.ofbiz.base.component.ComponentLoaderConfig.ComponentDef#of(Element, URL)}
     * {@link org.apache.ofbiz.base.start.Config#getDefaultLocale(Properties, String)}
     * {@link org.apache.ofbiz.base.util.SSLUtil#getHostnameVerifier(int)}
     * {@link org.apache.ofbiz.entity.transaction.TransactionUtil#getTransactionStateString(int)}
     */
    public static void task3_switchExpressions() {
    }

    /**
     * // Java 15
     * Replace fragmented Strings with Text Blocks - JEP 378
     * {@link org.apache.ofbiz.webapp.AfterLoginEvents}}
     * {@link org.apache.ofbiz.base.util.ScriptUtil#isSafeScript(String, String)}}
     * {@link org.apache.ofbiz.base.util.UtilNumber#RULE_SET_EN_US}
     * {@link org.apache.ofbiz.base.util.UtilNumber#RULE_SET_EN_IN}
     * {@link org.apache.ofbiz.base.util.UtilNumber#RULE_SET_TH_TH}
     */
    public static void task4_textBlocks() {
    }

    /**
     * // Java 16
     * Replace simple data classes with records - JEP 395
     * {@link org.apache.ofbiz.base.concurrent.ConstantFuture}
     * {@link org.apache.ofbiz.base.conversion.Converters.PassThruConverter}
     * {@link org.apache.ofbiz.entity.DelegatorFactory.DelegatorConfigurable}
     * {@link org.apache.ofbiz.base.util.collections.GenericMapEntry}
     * {@link org.apache.ofbiz.entity.model.ModelInfo}
     * {@link org.apache.ofbiz.entity.model.ModelViewEntity.ModelMemberEntity}
     */
    public static void task5_replaceDataClassesWithRecords() {
    }

    /**
     * // Java 16
     * Pattern Matching for instanceof - JEP 394
     * {@link org.apache.ofbiz.webapp.event.CoreEvents#getObjectFromServicePath(String, Map)}
     * {@link org.apache.ofbiz.entity.finder.EntityFinderUtil#expandFieldMapToContext(Map, Map, Map)}
     * {@link org.apache.ofbiz.base.util.collections.GenericMap#equals(Object)}
     * {@link org.apache.ofbiz.entity.model.ModelUtil#isPotentialLocalizedFields(ModelEntity, List)}
     * {@link org.apache.ofbiz.base.util.collections.FlexibleServletAccessor#equals(Object)}
     * {@link org.apache.ofbiz.entity.condition.EntityComparisonOperator#validateSql(ModelEntity, Object, Object)} (and others)
     */
    public static void task6_patternMatchingForInstanceof() {
    }

    /**
     * // Java 17
     * Tighten up hierarchies with sealed classes - JEP 409
     * {@link org.apache.ofbiz.entity.jdbc.AbstractCursorHandler}
     */
    public static void task7_sealedClasses() {
    }

    /**
     * // Java 18
     * REFACTOR: Code Snippets in Java API Documentation - JEP 413
     *
     * @see EntityConditionVisitor
     * @see ScriptHelper
     */
    public static void task8_codeSnippetsInAPIDocumentation() {
    }

    /**
     * // Java 21
     * REFACTOR: Sequenced Collections - JEP 431
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
     * @see org.apache.ofbiz.base.component.ComponentConfig#collectElements(Element, String, BiFunction)  (maybe)
     * @see org.apache.ofbiz.service.ModelService#allowHtmlValidation(Map, Map, Locale)
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