/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.cinema.business.custom.impl;

import java.sql.Connection;
import lk.ijse.cinema.business.custom.PaymentBO;
import lk.ijse.cinema.dao.DAOFactory;
import lk.ijse.cinema.dao.custom.PaymentDAO;
import lk.ijse.cinema.dao.custom.ReservationDAO;
import lk.ijse.cinema.dao.custom.TicketDAO;
import lk.ijse.cinema.db.DBConnection;
import lk.ijse.cinema.entity.Payment;
import lk.ijse.cinema.entity.Reservation;
import lk.ijse.cinema.entity.Ticket;
import lk.ijse.cinema.model.PaymentDTO;
import lk.ijse.cinema.model.ReservationDTO;
import lk.ijse.cinema.model.TicketDTO;

/**
 *
 * @author User
 */
public class PaymentBOImpl implements PaymentBO {

    private PaymentDAO paymentDAO;

    private ReservationDAO reservationDetailDAO;
    private TicketDAO ticketDAO;

    public PaymentBOImpl() {
        this.paymentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);

        this.reservationDetailDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RESERVATION);
        this.ticketDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.TICKET);
    }

    public boolean addPayment(PaymentDTO payment) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {

            boolean result = paymentDAO.save(new Payment(payment.getPid(), payment.getPayment_date(), payment.getAmount()));

            if (!result) {
                return false;
            }

            for (ReservationDTO reservationDTO : payment.getReservationDetails()) {

                result = reservationDetailDAO.save(new Reservation(reservationDTO.getRid(), reservationDTO.getReserved_date(), reservationDTO.getCid(), reservationDTO.getMid(), reservationDTO.getSeat_id(), reservationDTO.getReserved_time()));
                System.out.println("result : " + result);
                if (!result) {
                    connection.rollback();
                    return false;
                }
            }

            for (TicketDTO ticketDTO : payment.getTicketDetails()) {

                result = ticketDAO.save(new Ticket(ticketDTO.getTicket_no(), ticketDTO.getIssued_date(), ticketDTO.getPrice(), ticketDTO.getDid(), ticketDTO.getDiscount(), ticketDTO.getStid(), ticketDTO.getRid(), ticketDTO.getPid(), ticketDTO.getType()));

                if (!result) {
                    connection.rollback();
                    return false;
                }
            }

            connection.commit();
            return true;

        } finally {
            connection.setAutoCommit(true);
        }
    }
}
