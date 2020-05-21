/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.jps.incremental;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.jetbrains.kotlin.test.TestRoot;
import org.junit.runner.RunWith;

/*
 * This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}.
 * DO NOT MODIFY MANUALLY.
 */
@SuppressWarnings("all")
@TestRoot("jps/jps-plugin")
@TestDataPath("$CONTENT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class JsProtoComparisonTestGenerated extends AbstractJsProtoComparisonTest {
    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("testData/comparison/classSignatureChange")
    public static class ClassSignatureChange extends AbstractJsProtoComparisonTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        @TestMetadata("classAnnotationListChanged")
        public void testClassAnnotationListChanged() throws Exception {
            runTest("testData/comparison/classSignatureChange/classAnnotationListChanged/");
        }

        @TestMetadata("classFlagsAndMembersChanged")
        public void testClassFlagsAndMembersChanged() throws Exception {
            runTest("testData/comparison/classSignatureChange/classFlagsAndMembersChanged/");
        }

        @TestMetadata("classFlagsChanged")
        public void testClassFlagsChanged() throws Exception {
            runTest("testData/comparison/classSignatureChange/classFlagsChanged/");
        }

        @TestMetadata("classTypeParameterListChanged")
        public void testClassTypeParameterListChanged() throws Exception {
            runTest("testData/comparison/classSignatureChange/classTypeParameterListChanged/");
        }

        @TestMetadata("classWithSuperTypeListChanged")
        public void testClassWithSuperTypeListChanged() throws Exception {
            runTest("testData/comparison/classSignatureChange/classWithSuperTypeListChanged/");
        }

        @TestMetadata("nestedClassSignatureChanged")
        public void testNestedClassSignatureChanged() throws Exception {
            runTest("testData/comparison/classSignatureChange/nestedClassSignatureChanged/");
        }

        @TestMetadata("sealedClassImplAdded")
        public void testSealedClassImplAdded() throws Exception {
            runTest("testData/comparison/classSignatureChange/sealedClassImplAdded/");
        }

        @TestMetadata("sealedClassImplRemoved")
        public void testSealedClassImplRemoved() throws Exception {
            runTest("testData/comparison/classSignatureChange/sealedClassImplRemoved/");
        }

        @TestMetadata("sealedClassNestedImplAdded")
        public void testSealedClassNestedImplAdded() throws Exception {
            runTest("testData/comparison/classSignatureChange/sealedClassNestedImplAdded/");
        }

        @TestMetadata("sealedClassNestedImplAddedDeep")
        public void testSealedClassNestedImplAddedDeep() throws Exception {
            runTest("testData/comparison/classSignatureChange/sealedClassNestedImplAddedDeep/");
        }

        @TestMetadata("sealedClassNestedImplRemoved")
        public void testSealedClassNestedImplRemoved() throws Exception {
            runTest("testData/comparison/classSignatureChange/sealedClassNestedImplRemoved/");
        }
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("testData/comparison/classPrivateOnlyChange")
    public static class ClassPrivateOnlyChange extends AbstractJsProtoComparisonTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        @TestMetadata("classWithPrivateFunChanged")
        public void testClassWithPrivateFunChanged() throws Exception {
            runTest("testData/comparison/classPrivateOnlyChange/classWithPrivateFunChanged/");
        }

        @TestMetadata("classWithPrivatePrimaryConstructorChanged")
        public void testClassWithPrivatePrimaryConstructorChanged() throws Exception {
            runTest("testData/comparison/classPrivateOnlyChange/classWithPrivatePrimaryConstructorChanged/");
        }

        @TestMetadata("classWithPrivateSecondaryConstructorChanged")
        public void testClassWithPrivateSecondaryConstructorChanged() throws Exception {
            runTest("testData/comparison/classPrivateOnlyChange/classWithPrivateSecondaryConstructorChanged/");
        }

        @TestMetadata("classWithPrivateValChanged")
        public void testClassWithPrivateValChanged() throws Exception {
            runTest("testData/comparison/classPrivateOnlyChange/classWithPrivateValChanged/");
        }

        @TestMetadata("classWithPrivateVarChanged")
        public void testClassWithPrivateVarChanged() throws Exception {
            runTest("testData/comparison/classPrivateOnlyChange/classWithPrivateVarChanged/");
        }
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("testData/comparison/classMembersOnlyChanged")
    public static class ClassMembersOnlyChanged extends AbstractJsProtoComparisonTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        @TestMetadata("classWithCompanionObjectChanged")
        public void testClassWithCompanionObjectChanged() throws Exception {
            runTest("testData/comparison/classMembersOnlyChanged/classWithCompanionObjectChanged/");
        }

        @TestMetadata("classWithConstructorChanged")
        public void testClassWithConstructorChanged() throws Exception {
            runTest("testData/comparison/classMembersOnlyChanged/classWithConstructorChanged/");
        }

        @TestMetadata("classWithFunAndValChanged")
        public void testClassWithFunAndValChanged() throws Exception {
            runTest("testData/comparison/classMembersOnlyChanged/classWithFunAndValChanged/");
        }

        @TestMetadata("classWithNestedClassesChanged")
        public void testClassWithNestedClassesChanged() throws Exception {
            runTest("testData/comparison/classMembersOnlyChanged/classWithNestedClassesChanged/");
        }

        @TestMetadata("classWitnEnumChanged")
        public void testClassWitnEnumChanged() throws Exception {
            runTest("testData/comparison/classMembersOnlyChanged/classWitnEnumChanged/");
        }

        @TestMetadata("defaultValues")
        public void testDefaultValues() throws Exception {
            runTest("testData/comparison/classMembersOnlyChanged/defaultValues/");
        }

        @TestMetadata("membersAnnotationListChanged")
        public void testMembersAnnotationListChanged() throws Exception {
            runTest("testData/comparison/classMembersOnlyChanged/membersAnnotationListChanged/");
        }

        @TestMetadata("membersFlagsChanged")
        public void testMembersFlagsChanged() throws Exception {
            runTest("testData/comparison/classMembersOnlyChanged/membersFlagsChanged/");
        }

        @TestMetadata("nestedClassMembersChanged")
        public void testNestedClassMembersChanged() throws Exception {
            runTest("testData/comparison/classMembersOnlyChanged/nestedClassMembersChanged/");
        }

        @TestMetadata("sealedClassImplAdded")
        public void testSealedClassImplAdded() throws Exception {
            runTest("testData/comparison/classMembersOnlyChanged/sealedClassImplAdded/");
        }
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("testData/comparison/packageMembers")
    public static class PackageMembers extends AbstractJsProtoComparisonTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        @TestMetadata("defaultValues")
        public void testDefaultValues() throws Exception {
            runTest("testData/comparison/packageMembers/defaultValues/");
        }

        @TestMetadata("membersAnnotationListChanged")
        public void testMembersAnnotationListChanged() throws Exception {
            runTest("testData/comparison/packageMembers/membersAnnotationListChanged/");
        }

        @TestMetadata("membersFlagsChanged")
        public void testMembersFlagsChanged() throws Exception {
            runTest("testData/comparison/packageMembers/membersFlagsChanged/");
        }

        @TestMetadata("packageFacadePrivateOnlyChanges")
        public void testPackageFacadePrivateOnlyChanges() throws Exception {
            runTest("testData/comparison/packageMembers/packageFacadePrivateOnlyChanges/");
        }

        @TestMetadata("packageFacadePublicChanges")
        public void testPackageFacadePublicChanges() throws Exception {
            runTest("testData/comparison/packageMembers/packageFacadePublicChanges/");
        }
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("testData/comparison/unchanged")
    public static class Unchanged extends AbstractJsProtoComparisonTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        @TestMetadata("unchangedClass")
        public void testUnchangedClass() throws Exception {
            runTest("testData/comparison/unchanged/unchangedClass/");
        }

        @TestMetadata("unchangedPackageFacade")
        public void testUnchangedPackageFacade() throws Exception {
            runTest("testData/comparison/unchanged/unchangedPackageFacade/");
        }
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("testData/comparison/jsOnly")
    public static class JsOnly extends AbstractJsProtoComparisonTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        @TestMetadata("externals")
        public void testExternals() throws Exception {
            runTest("testData/comparison/jsOnly/externals/");
        }
    }
}
