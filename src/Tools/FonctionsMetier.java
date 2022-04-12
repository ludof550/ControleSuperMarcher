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
       ArrayList<Secteur> mesSecteur= new ArrayList<>();
        try {
            
            //on ecrit notre requete
            ps = cnx.prepareStatement("SELECT secteur.numS, secteur.nomS FROM secteur");
            // On execute notre rqt
            rs = ps.executeQuery();
            
            //on parcours le RésultSet
            //TANT QU' IL Y A DES ENREGISTREMENT (lignes)
            while (rs.next()) {
                Secteur lesSecteur = new Secteur(rs.getInt(1), rs.getString(2));
                mesSecteur.add(lesSecteur);
            }
            
    
            
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mesSecteur;
    
    }
    
    public ArrayList<Employe> GetAllEmployes()
    {
         ArrayList<Employe> mesEmployes= new ArrayList<>();
        try {
            
            //on ecrit notre requete
            ps = cnx.prepareStatement("SELECT employe.numE,employe.prenomE FROM employe");
            // On execute notre rqt
            rs = ps.executeQuery();
            
            //on parcours le RésultSet
            //TANT QU' IL Y A DES ENREGISTREMENT (lignes)
            while (rs.next()) {
                Employe lesEmployes = new Employe(rs.getInt(1), rs.getString(2));
                mesEmployes.add(lesEmployes);
            }
            
    
            
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mesEmployes;
    }
    
    public ArrayList<Rayon> GetAllRayonsByIdsecteur(int numSecteur)
    {
         ArrayList<Rayon> mesRayons= new ArrayList<>();
        try {
            
            //on ecrit notre requete
            ps = cnx.prepareStatement("SELECT rayon.numR,rayon.nomR\n" +
"FROM rayon,secteur\n" +
"WHERE rayon.numSecteur = secteur.numS\n" +
"AND secteur.numS = "+numSecteur);
            // On execute notre rqt
            rs = ps.executeQuery();
            
            //on parcours le RésultSet
            //TANT QU' IL Y A DES ENREGISTREMENT (lignes)
            while (rs.next()) {
                 Rayon  lesRayons= new Rayon(rs.getInt(1), rs.getString(2));
                mesRayons.add(lesRayons);
            }
            
    
            
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mesRayons;
    }
    
    public ArrayList<Travailler> GetAllTravailler(int numRayon)
    {
         ArrayList<Travailler> mesTravailles= new ArrayList<>();
        Employe mesEmployes = null;
         
        try {
            
             ps = cnx.prepareStatement("SELECT employe.numE,employe.prenomE FROM employe");
            // On execute notre rqt
            rs = ps.executeQuery();
            
            //on parcours le RésultSet
            //TANT QU' IL Y A DES ENREGISTREMENT (lignes)
            while (rs.next()) {
                Employe mesEmploye = new Employe(rs.getInt(1), rs.getString(2));
                
            }
            //on ecrit notre requete
            ps = cnx.prepareStatement("SELECT travailler.date , travailler.temps FROM travailler,rayon WHERE travailler.codeR = rayon.numR AND rayon.numR = "+numRayon);
            // On execute notre rqt
            rs = ps.executeQuery();
            
            //on parcours le RésultSet
            //TANT QU' IL Y A DES ENREGISTREMENT (lignes)
            while (rs.next()) {
                 Travailler  lesTravailles= new Travailler(mesEmployes,rs.getInt(1), rs.getString(2));
                mesTravailles.add(lesTravailles);
            }
            
    
            
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mesTravailles;
    }
    
    public int GetIdEmployeByNom(String nomEmploye)
    {
      int idEmploye = 0;
         
        try {
            
             ps = cnx.prepareStatement("SELECT employe.numE FROM employe WHERE employe.prenomE = '"+nomEmploye+"'");
            // On execute notre rqt
            rs = ps.executeQuery();
            
            //on parcours le RésultSet
            //TANT QU' IL Y A DES ENREGISTREMENT (lignes)
            rs.next();
            idEmploye = rs.getInt(1);
            
            
    
            
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return idEmploye;
    }
    
    public int TotalHeuresRayon(int numRayon)
    {
       int heure = 0;
         
        try {
            
             ps = cnx.prepareStatement("SELECT SUM(travailler.temps) FROM travailler, rayon WHERE travailler.codeR = rayon.numR AND rayon.numR = "+numRayon);
            // On execute notre rqt
            rs = ps.executeQuery();
            
            //on parcours le RésultSet
            //TANT QU' IL Y A DES ENREGISTREMENT (lignes)
            rs.next();
            heure = rs.getInt(1);
            
            
    
            
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return heure;
    }
    
    public void ModifierTemps(int codeEmploye, int CodeRayon, String uneDate,int nouveauTemps)
    {
        
    }
    
    public void InsererTemps(int codeEmploye, int CodeRayon,int nouveauTemps)
    {
        
    }
}
