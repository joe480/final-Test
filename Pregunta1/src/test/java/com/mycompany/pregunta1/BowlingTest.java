/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pregunta1;

import org.junit.Test;
import static org.junit.Assert.*;




/**
 *
 * @author User
 */
public class BowlingTest {
    
    public BowlingTest() {
    }
    Bowling bolos = new Bowling();
    
    @Test
    public void testAddTurno(){
        int expResult =1;
        int result = bolos.addTurno();
        assertEquals(expResult,result);
    }

    
}
