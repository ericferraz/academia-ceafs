function verificar(xhr, status, args, dlg, tbl) { // 3 primeiros padrão, não
	// mexa
	if (args.validationFailed) {
		PF(dlg).jq.effect("shake", {
			times : 5
		}, 100); // faz choacalhar
	} else {
		PF(dlg).hide();
		PF(tbl).clearFilters();
	}
}

function atualizarMensagem(xhr, status, args) {
	$.ajax(update = ":msgGlobal");
}

function verificar2(xhr, status, args, dlg) { // 3 primeiros padrão, não
	// mexa
	if (args.validationFailed) {
		PF(dlg).jq.effect("shake", {
			times : 5
		}, 100); // faz choacalhar
	} else {
		PF(dlg).hide();
	}
}
