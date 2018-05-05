package com.cinema.manager;

import com.cinema.model.Ticket;
import com.cinema.repository.TicketRepository;
import com.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketManager implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Ticket getTicket(Long id) {
        return ticketRepository.findOne(id);
    }

    @Override
    public Long updateTicket(Ticket ticket) {
        Ticket toUpdate = ticketRepository.findOne(ticket.getId());
        toUpdate.setReservations(ticket.getReservations());
        toUpdate.setUser(ticket.getUser());

        return ticketRepository.save(toUpdate).getId();
    }

    @Override
    public Long addTicket(Ticket ticket) {
        return ticketRepository.save(ticket).getId();
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.delete(id);
    }
}
