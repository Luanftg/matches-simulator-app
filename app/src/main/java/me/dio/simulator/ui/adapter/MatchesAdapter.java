package me.dio.simulator.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import me.dio.simulator.databinding.MatchItemBinding;
import me.dio.simulator.domain.Match;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {

    private List<Match> matches;

    public MatchesAdapter(List<Match> matches) {
        this.matches = matches;
    }

    @NonNull
    @Override
    public MatchesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MatchItemBinding binding = MatchItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchesAdapter.ViewHolder holder, int position) {
        Match match = matches.get(position);

        //Adapta os dados da partida (recuperada da API) para o nosso layout.
        Context context = holder.itemView.getContext();
        Glide.with(context).load(match.getHomeTeam().getImagem()).circleCrop().into(holder.binding.ivHomeTeam);
        holder.binding.tvHomeTeamName.setText(match.getHomeTeam().getName());
        Glide.with(context).load(match.getAwayTeam().getImagem()).circleCrop().into(holder.binding.ivAwayTeam);
        holder.binding.ivAwayTeamName.setText(match.getAwayTeam().getName());
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final MatchItemBinding binding;

        public ViewHolder(MatchItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
