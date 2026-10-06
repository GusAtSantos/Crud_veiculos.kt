<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Veiculo;

class VeiculosController extends Controller
{
    public function index() {
        $veiculos = Veiculo::get();
        
        return view('index')->with('veiculos', $veiculos);
    }    

    public function create() {
        return view('formulario');
    }

    public function store(Request $req) {
        $nome_do_veiculo = $req->nome_do_veiculo;
        $marca = $req->marca;
        $ano = intval($req->ano);
        $preco = intval($req->preco);
        $qualidade = $req->qualidade;

        $veic = new Veiculo();
        $veic->nome_do_veiculo = $nome_do_veiculo;
        $veic->marca = $marca;
        $veic->ano = $ano;
        $veic->preco = $preco;
        $veic->qualidade = $qualidade;
        $veic->save();

        return redirect('/');
    }
    public function edit($id) {
        $veiculo = Veiculo::find($id);
        if ($veiculo) {
            return view('formulario')->with('veiculo', $veiculo);
        } else {
            return redirect('/');
        }
    }

    public function update(Request $req, $id) {
        $veiculo = Veiculo::find($id);
        if ($veiculo) {
            $veiculo->nome_do_veiculo = $req->nome_do_veiculo;
            $veiculo->marca = $req->marca;
            $veiculo->ano = intval($req->ano);
            $veiculo->preco = floatval($req->preco);
            $veiculo->qualidade = intval($req->qualidade);
            $veiculo->save();
        }

        return redirect('/');
    }

    public function delete(Request $req) {
        $veic = Veiculo::find($req->id);
        if ($veic) {
            $veic->delete();
        }
        
        return redirect('/');
    }
}
