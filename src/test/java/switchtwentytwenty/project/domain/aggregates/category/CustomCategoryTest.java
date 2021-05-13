package switchtwentytwenty.project.domain.aggregates.category;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.FamilyID;

import static org.junit.jupiter.api.Assertions.*;

class CustomCategoryTest {

    @Test
    void testEquals() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        FamilyID familyID = new FamilyID("familyid@gmail.com");
        CustomCategory customCategory = new CustomCategory(categoryID, parentID, categoryName, familyID);
        CustomCategory customCategory2 = new CustomCategory(categoryID, parentID, categoryName, familyID);

        assertNotSame(customCategory, customCategory2);
        assertEquals(customCategory, customCategory2);
    }

    @Test
    void testEqualsFalseCategoryID() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        FamilyID familyID = new FamilyID("familyid@gmail.com");
        CustomCategory customCategory = new CustomCategory(categoryID, parentID, categoryName, familyID);
        CustomCategory customCategory2 = new CustomCategory(new CategoryID(5L), parentID, categoryName, familyID);


        assertNotEquals(customCategory, customCategory2);
    }

    @Test
    void testEqualsFalseParentID() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        FamilyID familyID = new FamilyID("familyid@gmail.com");
        CustomCategory customCategory = new CustomCategory(categoryID, parentID, categoryName, familyID);
        CustomCategory customCategory2 = new CustomCategory(categoryID, new CategoryID(6l), categoryName, familyID);

        assertNotSame(customCategory, customCategory2);
        assertNotEquals(customCategory, customCategory2);
    }

    @Test
    void testEqualsFalseCategoryName() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        FamilyID familyID = new FamilyID("familyid@gmail.com");
        CustomCategory customCategory = new CustomCategory(categoryID, parentID, categoryName, familyID);
        CustomCategory customCategory2 = new CustomCategory(categoryID, parentID, new CategoryName("newname"), familyID);

        assertNotSame(customCategory, customCategory2);
        assertNotEquals(customCategory, customCategory2);
    }

    @Test
    void testEqualsFalseFamilyID() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        FamilyID familyID = new FamilyID("familyid@gmail.com");
        CustomCategory customCategory = new CustomCategory(categoryID, parentID, categoryName, familyID);
        CustomCategory customCategory2 = new CustomCategory(categoryID, parentID, categoryName, new FamilyID("we@we.com"));

        assertNotSame(customCategory, customCategory2);
        assertNotEquals(customCategory, customCategory2);
    }


    @Test
    void testHashCode() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryName categoryName = new CategoryName("name");
        FamilyID familyID = new FamilyID("familyid@gmail.com");
        CustomCategory customCategory = new CustomCategory(categoryID, categoryName, familyID);
        CustomCategory customCategory2 = new CustomCategory(categoryID, categoryName, familyID);

        assertNotSame(customCategory, customCategory2);
        assertEquals(customCategory.hashCode(), customCategory2.hashCode());
    }

    @Test
    void id() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryName categoryName = new CategoryName("name");
        FamilyID familyID = new FamilyID("familyid@gmail.com");
        CustomCategory customCategory = new CustomCategory(categoryID, categoryName, familyID);

        CategoryID expected = new CategoryID(1L);
        CategoryID result = customCategory.id();

        assertEquals(expected, result);
        assertNotSame(expected, result);
    }

    @Test
    void hasID() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryName categoryName = new CategoryName("name");
        FamilyID familyID = new FamilyID("familyid@gmail.com");
        CustomCategory customCategory = new CustomCategory(categoryID, categoryName, familyID);

        CategoryID correctID = new CategoryID(1L);
        CategoryID wrongID = new CategoryID(5L);
        assertTrue(customCategory.hasID(correctID));
        assertFalse(customCategory.hasID(wrongID));
    }


    @Test
    void getParentID() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        FamilyID familyID = new FamilyID("familyid@gmail.com");
        CustomCategory customCategory = new CustomCategory(categoryID, parentID, categoryName, familyID);

        CategoryID expected = new CategoryID(2L);
        CategoryID result = customCategory.getParentID();


        assertEquals(expected, result);

    }

    @Test
    void getCategoryName() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        FamilyID familyID = new FamilyID("familyid@gmail.com");
        CustomCategory customCategory = new CustomCategory(categoryID, parentID, categoryName, familyID);

        CategoryName expected = new CategoryName("name");
        CategoryName result = customCategory.getCategoryName();
        assertEquals(expected, result);

    }

    @Test
    void getFamilyID() {
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        FamilyID familyID = new FamilyID("familyid@gmail.com");
        CustomCategory customCategory = new CustomCategory(categoryID, parentID, categoryName, familyID);

        FamilyID expected = new FamilyID("familyid@gmail.com");
        FamilyID result = customCategory.getFamilyID();

        assertEquals(expected, result);

    }

    @Test
    void setCategoryID() {
        CategoryID newID = new CategoryID(6L);
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        FamilyID familyID = new FamilyID("familyid@gmail.com");
        CustomCategory customCategory = new CustomCategory(categoryID, parentID, categoryName, familyID);

        customCategory.setCategoryID(newID);
        CategoryID expected = new CategoryID(6L);
        CategoryID result = customCategory.id();

        assertEquals(expected, result);


    }

    @Test
    void setParentID() {
        CategoryID newID = new CategoryID(6L);
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        FamilyID familyID = new FamilyID("familyid@gmail.com");
        CustomCategory customCategory = new CustomCategory(categoryID, parentID, categoryName, familyID);

        customCategory.setParentID(newID);
        CategoryID expected = new CategoryID(6L);
        CategoryID result = customCategory.getParentID();

        assertEquals(expected, result);
    }

    @Test
    void setCategoryName() {
        CategoryName newName = new CategoryName("6L");
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        FamilyID familyID = new FamilyID("familyid@gmail.com");
        CustomCategory customCategory = new CustomCategory(categoryID, parentID, categoryName, familyID);

        customCategory.setCategoryName(newName);
        CategoryName expected = new CategoryName("6L");
        CategoryName result = customCategory.getCategoryName();

        assertEquals(expected, result);

    }

    @Test
    void setFamilyID() {
        FamilyID newFamilyID = new FamilyID("newid@gmail.com");
        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        FamilyID familyID = new FamilyID("familyid@gmail.com");
        CustomCategory customCategory = new CustomCategory(categoryID, parentID, categoryName, familyID);

        customCategory.setFamilyID(newFamilyID);
        FamilyID expected = new FamilyID("newid@gmail.com");
        FamilyID result = customCategory.getFamilyID();

        assertEquals(expected, result);
    }

    @Test
    void noArgsConstructorTest() {

        CategoryID categoryID = new CategoryID(1L);
        CategoryID parentID = new CategoryID(2L);
        CategoryName categoryName = new CategoryName("name");
        FamilyID familyID = new FamilyID("familyid@gmail.com");
        CustomCategory customCategory = new CustomCategory();

        customCategory.setCategoryID(categoryID);
        customCategory.setCategoryName(categoryName);
        customCategory.setFamilyID(familyID);
        customCategory.setParentID(parentID);

        assertNotNull(customCategory);

    }
}