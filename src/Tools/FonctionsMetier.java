/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Entity.Employe;
import Entity.Rayon;
import Entity.Secteur;
import Entity.Travailler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jbuffeteau
 */
public class FonctionsMetier
{
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cnx;

    public FonctionsMetier()
    {
        cnx = ConnexionBDD.getCnx();
    }
    
    public ArrayList<Secteur> GetAllSecteurs()
    {
        return null;
    }
    
    public ArrayList<Employe> GetAllEmployes()
    {
        return null;
    }
    
    public ArrayList<Rayon> GetAllRayonsByIdsecteur(int numSecteur)
    {
        return null;
    }
    
    public ArrayList<Travailler> GetAllTravailler(int numRayon)
    {
        return null;
    }
    
    public int GetIdEmployeByNom(String nomEmploye)
    {
        return 0;
    }
    
    public int TotalHeuresRayon(int numRayon)
    {
        return 0;
    }
    
    public void ModifierTemps(int codeEmploye, int CodeRayon, String uneDate,int nouveauTemps)
    {
        
    }
    
    public void InsererTemps(int codeEmploye, int CodeRayon,int nouveauTemps)
    {
        
    }
}
