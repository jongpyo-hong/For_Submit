package org.koreait.controllers.board;

import jakarta.validation.Valid;
import org.koreait.models.board.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardSaveService saveService;
    @Autowired
    private BoardListService listService;
    @Autowired
    private BoardViewService viewService;
    @Autowired
    private BoardDeleteService deleteService;
    @Autowired
    private BoardModifyService modifyService;
    @Autowired
    private BoardDao boardDao;
    @GetMapping("/write")
    public String write(@ModelAttribute BoardForm boardForm) {

        return "board/write";
    }

    @PostMapping("/save")
    public String save(@Valid BoardForm boardForm, Errors errors) {
        if(errors.hasErrors()) {
            return "board/write";
        }

        saveService.save(boardForm);

        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> items = listService.gets();
        model.addAttribute("items", items);

        return "board/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Board view = viewService.get(id);
        model.addAttribute("view", view);

        return "board/view";
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable Long id, Errors errors) {

        if(errors.hasErrors()) {
            return "board/view";
        }
        modifyService.modify(id);

        return "redirect:/board/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Board board = boardDao.get(id);
        deleteService.delete(board.getId());

        return "redirect:/board/list";
    }


}
