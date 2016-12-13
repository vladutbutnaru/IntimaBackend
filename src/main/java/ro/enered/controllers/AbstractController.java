package ro.enered.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.enered.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by macbook on 29/11/2016.
 */
public abstract class AbstractController {
    public static Logger logger = LoggerFactory.getLogger(AbstractController.class);
    public static Connection conn = (Connection) DBConnection.getConnection();

}
