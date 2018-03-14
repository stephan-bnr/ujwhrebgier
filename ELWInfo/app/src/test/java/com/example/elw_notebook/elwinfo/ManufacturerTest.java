package com.example.elw_notebook.elwinfo;

import com.example.elw_notebook.elwinfo.dataObjects.Manufacturer;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

/**
 * Created by ELW-Notebook on 14.03.2018.
 */

public class ManufacturerTest {

    @Test
    public  void testGetName() {
        Assert.assertTrue(Manufacturer.AUDI.getName().equals("Audi"));
    }
    @Test
    public void testGetManufacturerByName() {
        Assert.assertEquals(Manufacturer.AUDI, Manufacturer.getManufacturerByName("sv rjiaudikrm"));
    }
}
