/**********************************************************************
 * $Source: /cvsroot/jameica/jameica/src/de/willuhn/jameica/rmi/Attic/DBIterator.java,v $
 * $Revision: 1.5 $
 * $Date: 2003/11/30 16:23:09 $
 * $Author: willuhn $
 * $Locker:  $
 * $State: Exp $
 *
 * Copyright (c) by  bbv AG
 * All rights reserved
 *
 **********************************************************************/
package de.willuhn.jameica.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author willuhn
 */
public interface DBIterator extends Remote {


  /**
   * Fuegt dem Iterator einen zusaetzlichen Filter hinzu, der
   * sich auf die Anzahl der Treffer auswirkt. Bsp:
   * addFilter("kontonummer='2020'");
   * Bewirkt, dass eine zusaetzliche Where-Klausel "where kontonummer='2020'"
   * hinzugefuegt wird.
   * @throws RemoteException
   */
  public void addFilter(String filter) throws RemoteException;
  
  /**
   * Fuegt dem Iterator eine Sortierung hinzu.
   * @param order
   * @throws RemoteException
   */
  public void setOrder(String order) throws RemoteException;
	/**
	 * Liefert true, wenn weitere Elemente in diesem Iterator existieren.
	 * @return true, wenn weitere Elemente vorhanden sind.
	 * @throws RemoteException
	 */
	public boolean hasNext() throws RemoteException;

	/**
	 * Liefert das aktuelle Element der Iteration und blaettert um ein Element weiter.
	 * @return aktuelles Element.
	 * @throws RemoteException
	 */
	public DBObject next() throws RemoteException;

  /**
   * Liefert das aktuelle Element der Iteration und blaetter um ein Element zurueck.
   * @return aktuelles Element.
   * @throws RemoteException
   */
  public DBObject previous() throws RemoteException;


  /**
   * Damit kann man manuell eine Transaktion starten.
   * Normalerweise wir bei store() oder delete() sofort
   * bei Erfolg ein commit gemacht. Wenn man aber von
   * aussen das Transaktionsverhalten beeinflussen will,
   * kann man diese Methode aufruefen. Hat man dies
   * getan, werden store() und delete() erst dann in
   * der Datenbank ausgefuehrt, wenn man anschliessend
   * transactionCommit() aufruft.
   * Die Transaktion bezieht sich auf die gesamte Liste!
   * @throws RemoteException
   */
  public void transactionBegin() throws RemoteException;
  
  /**
   * Beendet eine manuell gestartete Transaktion.
   * Wenn vorher kein transactionBegin aufgerufen wurde,
   * wird dieser Aufruf ignoriert.
   * @throws RemoteException
   */
  public void transactionCommit() throws RemoteException;

  /**
   * Rollt die angefangene Transaktion manuell zurueck.
   * @throws RemoteException
   */
  public void transactionRollback() throws RemoteException;


  /**
   * Liefert die Anzahl der Elemente dieses Iterators.
   * @return
   * @throws RemoteException
   */
  public int size() throws RemoteException;
}


/*********************************************************************
 * $Log: DBIterator.java,v $
 * Revision 1.5  2003/11/30 16:23:09  willuhn
 * *** empty log message ***
 *
 * Revision 1.4  2003/11/22 20:43:05  willuhn
 * *** empty log message ***
 *
 * Revision 1.3  2003/11/21 02:10:21  willuhn
 * @N prepared Statements in AbstractDBObject
 * @N a lot of new SWT parts
 *
 * Revision 1.2  2003/11/20 03:48:42  willuhn
 * @N first dialogues
 *
 * Revision 1.1  2003/11/05 22:46:19  willuhn
 * *** empty log message ***
 *
 * Revision 1.3  2003/10/29 20:56:49  willuhn
 * @N added transactionRollback
 *
 * Revision 1.2  2003/10/29 17:33:21  willuhn
 * *** empty log message ***
 *
 * Revision 1.1  2003/10/27 11:49:12  willuhn
 * @N added DBIterator
 *
 **********************************************************************/