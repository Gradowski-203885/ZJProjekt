package com.cinema.service;

import com.cinema.model.Ticket;

public interface TicketService {
    Ticket getTicket(Long id);
    Long updateTicket(Ticket ticket);
    Long addTicket(Ticket ticket);
    void deleteTicket(Long id);
}
